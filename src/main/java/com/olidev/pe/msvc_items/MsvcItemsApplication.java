package com.olidev.pe.msvc_items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // AQUI
@SpringBootApplication
public class MsvcItemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcItemsApplication.class, args);
    }

}
