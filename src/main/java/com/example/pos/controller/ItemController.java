package com.example.pos.controller;

import com.example.pos.common.ResponseBuilder;
import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.CustomerDTO;
import com.example.pos.dto.ItemDto;
import com.example.pos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    ItemService itemService;
    @GetMapping("/list")
    public ResponseEntity<ResponseHolder<List<ItemDto>>> getALlItems() {
        List<ItemDto> dtoList = itemService.getAll();
        return ResponseBuilder.okResponseBuilder(dtoList).build();
    }

    @GetMapping("/add")
    public ResponseEntity<ResponseHolder<String>> addItemToSystem(@RequestParam ItemDto itemDto) {
        return itemService.addItem(itemDto);
    }

    @GetMapping("/details")
    public ResponseEntity<ResponseHolder<String>> addItemToOrder(@RequestParam Long id) {
        return itemService.getItemDetailsById(id);
    }
}
