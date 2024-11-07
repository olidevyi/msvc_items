package com.olidev.pe.msvc_items.services;

import com.olidev.pe.msvc_items.dtos.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long id);
}
