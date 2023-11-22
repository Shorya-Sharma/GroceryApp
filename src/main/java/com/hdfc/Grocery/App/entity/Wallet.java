package com.hdfc.Grocery.App.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallet")
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "purchase_amount")
    private double purchaseAmount;

    @Column(name = "discount_fraction")
    private double discountFraction;

    // Constructors, getters, and setters

    // ...
}

