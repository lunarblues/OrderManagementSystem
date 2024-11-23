package com.ordermanagementsystem.orderservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.protocol.types.Field;

@Entity
@Table(name = "orders", schema = "public")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@TODO create separate entity class for product
    @Column(name = "product")
    private String product;

    @Column(nullable = false, name = "quantity")
    private int quantity;

    @Column(nullable = false, name = "user_id")
    private long userId;

}
