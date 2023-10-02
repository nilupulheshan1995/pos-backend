package com.example.pos.service;

import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getAll();
    ResponseEntity<ResponseHolder<String>> createNewCustomer(CustomerDTO customer);
}
