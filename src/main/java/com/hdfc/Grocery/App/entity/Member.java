package com.hdfc.Grocery.App.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    private String password;

    // Constructors, getters, and setters
}

