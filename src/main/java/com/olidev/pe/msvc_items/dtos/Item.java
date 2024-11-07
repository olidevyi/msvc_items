package com.olidev.pe.msvc_items.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private Product product;
    private int quantity;

    public Double getTotal() {
        return product.getPrice() * quantity;
    }
}
