package com.olidev.pe.msvc_items.controllers;

import com.olidev.pe.msvc_items.dtos.Item;
import com.olidev.pe.msvc_items.services.ItemService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {

    @Qualifier("itemServiceWebClient")
    private final ItemService service; // de las 2 clases que implementan ItemService se escoge ItemServiceWebClient

    @GetMapping
    public List<Item> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional<Item> itemOptional = service.findById(id);

        if (itemOptional.isPresent()) {
            return ResponseEntity.ok(itemOptional.get());
        }
        return ResponseEntity.status(404).body(Collections.singletonMap("Message", "No existe el producto en el microservicio msvc_products"));
    }
}
