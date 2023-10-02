package com.example.pos.entity;


import com.example.pos.dto.ItemDto;
import com.example.pos.dto.OrderDto;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order-details")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrderEntity orderEntity;

    @ManyToOne
    private ItemEntity itemEntity;

    private int quantity;
}
