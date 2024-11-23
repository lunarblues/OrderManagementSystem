package com.ordermanagementsystem.orderservice.service;

import com.ordermanagementsystem.dto.OrderDTO;
import com.ordermanagementsystem.orderservice.Converter.OrderConverter;
import com.ordermanagementsystem.orderservice.repository.HazelcastRepository;
import com.ordermanagementsystem.orderservice.repository.OrderRepository;
import com.ordermanagementsystem.orderservice.security.SignedUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderService {
    private final HazelcastRepository hazelcastRepository;
    private final OrderRepository orderRepository;
    private final SignedUser user;

    public List<OrderDTO> getOrders() {
        return hazelcastRepository.findByUserId(user.getUserId());
    }

    public void addOrder(OrderDTO orderDTO) {
        orderDTO.setUserId(user.getUserId());
        hazelcastRepository.saveOrder(orderDTO);
        orderRepository.save(OrderConverter.dtoToEntity(orderDTO));
    }

    public List<OrderDTO> getAllTimeOrders() {
        return orderRepository.findAll().stream().map(order -> OrderConverter.entityToDTO(order)).collect(Collectors.toList());
    }

}
