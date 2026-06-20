package com.wesleysfernandes.benefithub.product.controller;

import com.wesleysfernandes.benefithub.product.dto.CreateProductRequest;
import com.wesleysfernandes.benefithub.product.dto.ProductResponse;
import com.wesleysfernandes.benefithub.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponse create(
            @RequestBody CreateProductRequest request
            ) {
        return service.create(request);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(
            @PathVariable UUID id
            ) {
        return service.findById(id);
    }
}
