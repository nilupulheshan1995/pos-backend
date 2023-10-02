package com.example.pos.service.impl;

import com.example.pos.common.ResponseBuilder;
import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.ItemDto;
import com.example.pos.dto.OrderConverter;
import com.example.pos.dto.OrderDto;
import com.example.pos.entity.OrderDetailsEntity;
import com.example.pos.entity.OrderEntity;
import com.example.pos.exception.BadRequestException;
import com.example.pos.repository.OrderRepository;
import com.example.pos.service.ItemService;
import com.example.pos.service.OrderDetailService;
import com.example.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    // DB service
    @Autowired
    OrderRepository orderRepository;

    // Other services
    @Autowired
    ItemService itemService;
    @Autowired
    OrderDetailService orderDetailService;

    // beans
    @Autowired
    OrderConverter orderConverter;

    @Override
    public List<OrderDto> getAll() {
        List<OrderEntity> entities = orderRepository.findAll();
        return entities.stream().map(orderConverter::convertToDto).collect(Collectors.toList());
    }

    public OrderDto getOrderById(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow();
        return orderConverter.convertToDto(orderEntity);

    }


    @Override
    public ResponseEntity<ResponseHolder<ItemDto>> addItemToOrder(Long orderId, Long itemId) {
        ItemDto itemDto = itemService.findById(itemId).orElseThrow();

        OrderDto orderDto = getOrderById(orderId);
        orderDetailService.saveDetails(orderId,itemId);
        return ResponseBuilder.okResponseBuilder(itemDto).build();
    }

    @Override
    public ResponseEntity<ResponseHolder<OrderDto>> createOrder(OrderDto orderDto) {
        OrderEntity orderEntity = orderRepository.save(orderConverter.convertToEntity(orderDto));
        orderDto.getItemList().stream().map(itemDto -> orderDetailService.saveDetails(orderDto.getOrderId(),itemDto.getItemId()));
        return ResponseBuilder.okResponseBuilder(orderConverter.convertToDto(orderEntity)).build();
    }
}
