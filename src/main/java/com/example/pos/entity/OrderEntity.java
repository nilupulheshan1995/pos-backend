package com.example.pos.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "order-table")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;
}
