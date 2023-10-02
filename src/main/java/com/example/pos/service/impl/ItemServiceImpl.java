package com.example.pos.service.impl;

import com.example.pos.common.ResponseHolder;
import com.example.pos.dto.ItemDto;
import com.example.pos.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public List<ItemDto> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseHolder<String>> addItem(ItemDto itemDto) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseHolder<String>> getItemDetailsById(Long id) {
        return null;
    }

    @Override
    public Optional<ItemDto> findById(long l) {
        return Optional.empty();
    }
}
