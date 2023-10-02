package com.example.pos.service;

import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.CustomerDTO;
import com.example.pos.dto.ItemDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<ItemDto> getAll();
    ResponseEntity<ResponseHolder<String>> addItem(ItemDto itemDto);
    ResponseEntity<ResponseHolder<String>> getItemDetailsById(Long id);
    Optional<ItemDto> findById(long l);
}
