package com.example.pos.dto;

import com.example.pos.entity.CustomerEntity;
import com.example.pos.entity.OrderEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class OrderConverter {
    final ModelMapper modelMapper;
    final ObjectMapper objectMapper;

    public OrderConverter(ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public OrderEntity convertToEntity(OrderDto dto) {
        return modelMapper.map(dto, OrderEntity.class);
    }

    public OrderDto convertToDto(OrderEntity entity) {
        return modelMapper.map(entity, OrderDto.class);
    }
}
