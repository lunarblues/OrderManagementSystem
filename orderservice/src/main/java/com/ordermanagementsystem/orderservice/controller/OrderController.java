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

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order was successfully removed");
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable("id") long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/orders/{get-all-orders}")
    public ResponseEntity<List<OrderDTO>> orders() {
        return ResponseEntity.ok(orderService.getAllOrdersForManager());
    }

    @PostMapping("/orders/complete/{id}")
    public ResponseEntity<String> completeOrder(long id) {
        orderService.completeOrder(id);
        return ResponseEntity.ok("Order is completed");
    }

}
