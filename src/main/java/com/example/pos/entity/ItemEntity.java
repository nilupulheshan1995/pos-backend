package com.example.pos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item-table")
@Data
public class ItemEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String itemName;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price")
    private Integer price;

}
