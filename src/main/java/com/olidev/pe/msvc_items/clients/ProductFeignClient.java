package com.olidev.pe.msvc_items.clients;

import com.olidev.pe.msvc_items.dtos.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "localhost:8001", name = "msvc-products")
public interface ProductFeignClient {

    // Estos métodos ya están implementados en el proyecto msvc_products, solo se replican aquí.
    @GetMapping
    List<Product> findAll();
    @GetMapping("/{id}")
    Product details(@PathVariable Long id);
}
