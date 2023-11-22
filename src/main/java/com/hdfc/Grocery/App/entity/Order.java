package com.hdfc.Grocery.App.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal totalAmount;

    private Timestamp orderDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Linking to the Product entity


    // Constructors, getters, and setters

    // ...
}
