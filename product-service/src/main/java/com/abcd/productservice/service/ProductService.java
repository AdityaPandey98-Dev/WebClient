package com.abcd.productservice.service;

import com.abcd.productservice.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient webClient;

    public User getUser(Long id){

        return webClient

                .get()

                .uri("/users/{id}",id)

                .retrieve()

                .bodyToMono(User.class)

                .block();

    }

}