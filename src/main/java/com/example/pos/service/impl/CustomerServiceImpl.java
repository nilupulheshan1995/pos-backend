package com.example.pos.service.impl;

import com.example.pos.common.ResponseBuilder;
import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.CustomerConverter;
import com.example.pos.dto.CustomerDTO;
import com.example.pos.entity.CustomerEntity;
import com.example.pos.repository.CustomerRepository;
import com.example.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream().map(customerConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ResponseHolder<String>> createNewCustomer(CustomerDTO customer) {
        CustomerEntity customerEntity = customerConverter.convertToEntity(customer);
        CustomerEntity save = customerRepository.save(customerEntity);
        return ResponseBuilder.okResponseBuilder("Customer saving successful").build();
    }
}
