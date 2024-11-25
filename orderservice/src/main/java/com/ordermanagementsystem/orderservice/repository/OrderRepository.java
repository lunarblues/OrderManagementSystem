package com.ordermanagementsystem.orderservice.repository;

import com.ordermanagementsystem.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(long id);

    @Query(value = "SELECT u.email FROM public.orders o " +
            "JOIN public.users u ON o.user_id = u.id " +
            "WHERE o.id = :orderId",
            nativeQuery = true)
    String findUserEmailByOrderId(Long orderId);
}
