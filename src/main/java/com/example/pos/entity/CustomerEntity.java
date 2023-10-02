package com.example.pos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer-table")
@Data
public class CustomerEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private Integer telephone;

}
