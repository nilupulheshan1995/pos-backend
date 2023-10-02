package com.example.pos.dto;

import com.example.pos.entity.CustomerEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

public class CustomerConverter {

    final ModelMapper modelMapper;
    final ObjectMapper objectMapper;

    public CustomerConverter(ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public CustomerEntity convertToEntity(CustomerDTO customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }

    public CustomerDTO convertToDto(CustomerEntity entity) {
        return modelMapper.map(entity, CustomerDTO.class);
    }
}
