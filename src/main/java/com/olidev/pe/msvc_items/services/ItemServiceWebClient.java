package com.olidev.pe.msvc_items.services;

import com.olidev.pe.msvc_items.dtos.Item;
import com.olidev.pe.msvc_items.dtos.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.*;

// @Primary // Como la interfaz ItemService la implementan 2 clases, elegiremos esta (ItemServiceWebClient) como la principal.
@Service
@RequiredArgsConstructor
public class ItemServiceWebClient implements ItemService {

    private final WebClient.Builder client; // De la clase WebClientConfig

    @Override
    public List<Item> findAll() {
        return this.client.build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Product.class) // Flux es cuando recibirá más de 1 valor
                .map(product -> new Item(product, new Random().nextInt(10) + 1))
                .collectList()
                .block();
    }

    @Override
    public Optional<Item> findById(Long id) {
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);

        try {
            return Optional.ofNullable(
                    client
                            .build()
                            .get()
                            .uri("/{id}", params)
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToMono(Product.class) // Mono es cuando recibirá solo 1 valor
                            .map(product -> new Item(product, new Random().nextInt(10) + 1))
                            .block()
            );
        } catch (WebClientResponseException e) {
            return Optional.empty();
        }
    }
}
