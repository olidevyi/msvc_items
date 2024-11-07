package com.olidev.pe.msvc_items.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Double price;
    private LocalDate createAt;
    // NUEVO, para ver desde el microservicio 2 (cliente que consume microservicio 1 en sus diferentes puertos balanceando la carga)
    private int port;
}
