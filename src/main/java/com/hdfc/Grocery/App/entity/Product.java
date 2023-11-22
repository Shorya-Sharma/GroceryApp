package com.hdfc.Grocery.App.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Double price;

    private String description;

    private String image;

    // Constructors, getters, and setters

    // ...
}

