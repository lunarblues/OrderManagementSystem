package com.ordermanagementsystem.orderservice.Converter;

import com.ordermanagementsystem.dto.OrderDTO;
import com.ordermanagementsystem.orderservice.model.Order;

public class OrderConverter {

    public static Order dtoToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setProduct(orderDTO.getProduct());
        order.setQuantity(orderDTO.getQuantity());
        order.setUserId(orderDTO.getUserId());
        return order;
    }

    public static OrderDTO entityToDTO(Order order) {
        return new OrderDTO(
                order.getProduct(),
                order.getQuantity(),
                order.getUserId()
        );
    }
}

