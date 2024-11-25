package com.ordermanagementsystem.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordermanagementsystem.dto.OrderDTO;
import com.ordermanagementsystem.event.OrderEvent;
import com.ordermanagementsystem.orderservice.Converter.OrderConverter;
import com.ordermanagementsystem.orderservice.kafka.EventProducer;
import com.ordermanagementsystem.orderservice.model.Order;
import com.ordermanagementsystem.orderservice.repository.HazelcastRepository;
import com.ordermanagementsystem.orderservice.repository.OrderRepository;
import com.ordermanagementsystem.orderservice.security.SignedUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderService {
    private final HazelcastRepository hazelcastRepository;
    private final OrderRepository orderRepository;
    private final SignedUser user;
    private final EventProducer eventProducer;
    private final ObjectMapper objectMapper;

    public OrderDTO getOrder(long id) {
        //searching through only user's orders
        return getOrders()
                .stream()
                .filter(order -> order.getOrderId() == id)
                .findFirst().orElseThrow();
    }

    public List<OrderDTO> getOrders() {
        return hazelcastRepository.findByUserId(user.getUserId());
    }

    public void addOrder(OrderDTO orderDTO) {
        orderDTO.setUserId(user.getUserId());
        Order order = orderRepository.save(OrderConverter.dtoToEntity(orderDTO));
        orderDTO.setOrderId(order.getId());
        hazelcastRepository.saveOrder(orderDTO);
        OrderEvent event = new OrderEvent(user.getMail());
        try {
            String message = objectMapper.writeValueAsString(event);
            eventProducer.sendEvent("OrderPlaced", null, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing event: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error sending event to Kafka: " + e.getMessage(), e);
        }
    }

    public List<OrderDTO> getAllTimeOrders() {
        return orderRepository.findAllByUserId(user.getUserId()).stream().map(order -> OrderConverter.entityToDTO(order)).collect(Collectors.toList());
    }

    public void deleteOrder(long orderId) {
        if(!Objects.isNull(getOrder(orderId)))
            hazelcastRepository.removeOrder(orderId);
    }

    public List<OrderDTO> getAllOrdersForManager() {
        return hazelcastRepository.findAll();
    }

    public void completeOrder(long orderId) {
        hazelcastRepository.removeOrder(orderId);
        String mail = orderRepository.findUserEmailByOrderId(orderId);
        OrderEvent event = new OrderEvent(mail);
        try {
            String message = objectMapper.writeValueAsString(event);
            eventProducer.sendEvent("OrderCompleted", null, message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing event: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error sending event to Kafka: " + e.getMessage(), e);
        }
    }

}
