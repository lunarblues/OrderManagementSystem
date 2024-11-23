package com.ordermanagementsystem.orderservice.controller;

import com.ordermanagementsystem.dto.OrderDTO;
import com.ordermanagementsystem.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping("/orders")
    public ResponseEntity<String> addOrder(@RequestBody @Valid final OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        return ResponseEntity.ok("Order added successfully");
    }

}
