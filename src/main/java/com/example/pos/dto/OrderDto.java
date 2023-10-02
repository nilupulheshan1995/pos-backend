package com.example.pos.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long orderId;
    private List<ItemDto> itemList;
}
