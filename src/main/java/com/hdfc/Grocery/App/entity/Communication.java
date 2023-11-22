package com.hdfc.Grocery.App.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "communications")
@Data
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Other communication details

    // Constructors, getters, setters

    // ...
}

