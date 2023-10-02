package com.example.pos.service;

import com.example.pos.entity.OrderDetailsEntity;

public interface OrderDetailService {
    boolean saveDetails(Long orderId,Long itemId);
}
