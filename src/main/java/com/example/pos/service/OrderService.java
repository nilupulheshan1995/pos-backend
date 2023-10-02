package com.example.pos.service;

import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.ItemDto;
import com.example.pos.dto.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll();

    ResponseEntity<ResponseHolder<ItemDto>> addItemToOrder(Long orderId, Long itemId);

    ResponseEntity<ResponseHolder<OrderDto>> createOrder(OrderDto orderDto);
}
