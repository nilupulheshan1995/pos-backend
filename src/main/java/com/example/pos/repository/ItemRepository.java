package com.example.pos.repository;

import com.example.pos.dto.ItemDto;
import com.example.pos.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

}
