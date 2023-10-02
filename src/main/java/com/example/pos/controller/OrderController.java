package com.example.pos.controller;

import com.example.pos.common.ResponseBuilder;
import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.ItemDto;
import com.example.pos.dto.OrderDto;
import com.example.pos.service.ItemService;
import com.example.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/place")
    public ResponseEntity<ResponseHolder<OrderDto>> placeOrder(@RequestParam OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PostMapping("/addItem")
    public ResponseEntity<ResponseHolder<ItemDto>> addItemToOrder(@RequestParam Long orderId,Long ItemId) {
        return orderService.addItemToOrder(orderId, ItemId);
    }

    @GetMapping("/getALl")
    public ResponseEntity<ResponseHolder<List<OrderDto>>> getAll() {
        List<OrderDto> dtoList = orderService.getAll();
        return ResponseBuilder.okResponseBuilder(dtoList).build();
    }


}
