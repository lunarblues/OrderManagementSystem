package com.ordermanagementsystem.orderservice.repository;

import com.ordermanagementsystem.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
