package com.abcd.productservice.controller;

import com.abcd.productservice.dto.User;
import com.abcd.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){

        return productService.getUser(id);

    }

}