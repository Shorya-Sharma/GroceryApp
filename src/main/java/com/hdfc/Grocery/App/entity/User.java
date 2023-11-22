package com.hdfc.Grocery.App.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "historical_total_spent")
    private BigDecimal historicalTotalSpent;

    @Column(name = "wallet_amount")
    private BigDecimal walletAmount;

    public User(String username, BigDecimal historicalTotalSpent, BigDecimal walletAmount) {
        this.username = username;
        this.historicalTotalSpent = historicalTotalSpent;
        this.walletAmount = walletAmount;
    }

    public User() {

    }


    // Other fields, constructors, getters, and setters
}

