package com.example.pos.controller;

import com.example.pos.common.ResponseBuilder;
import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.CustomerDTO;
import com.example.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.openmbean.CompositeData;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/list")
    public ResponseEntity<ResponseHolder<List<CustomerDTO>>> getAllCustomers() {
        List<CustomerDTO> dtoList = customerService.getAll();
        return ResponseBuilder.okResponseBuilder(dtoList).build();
    }

    @GetMapping("/create")
    public ResponseEntity<ResponseHolder<String>> createCustomer(@RequestParam CustomerDTO customer) {
        return customerService.createNewCustomer(customer);
    }


}
