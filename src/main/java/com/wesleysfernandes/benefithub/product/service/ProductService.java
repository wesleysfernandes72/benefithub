package com.wesleysfernandes.benefithub.product.service;

import com.wesleysfernandes.benefithub.product.dto.CreateProductRequest;
import com.wesleysfernandes.benefithub.product.dto.ProductResponse;
import com.wesleysfernandes.benefithub.product.entity.Product;
import com.wesleysfernandes.benefithub.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductResponse create(CreateProductRequest request) {
        repository.findByCode(request.code().toUpperCase())
                .ifPresent(product -> {
                    throw new RuntimeException("Already exists a product with the provided code");
                });

        Product product = Product.builder()
                .code(request.code().toUpperCase())
                .name(request.name())
                .description(request.description())
                .minimumIncome(request.minimumIncome())
                .active(true)
                .build();

        Product savedProduct = repository.save(product);

        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getCode(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getMinimumIncome(),
                savedProduct.getActive()
        );
    }

    public List<ProductResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getCode(),
                        product.getName(),
                        product.getDescription(),
                        product.getMinimumIncome(),
                        product.getActive()
                ))
                .toList();
    }

    public ProductResponse findById(UUID id) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        return new ProductResponse(
                product.getId(),
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getMinimumIncome(),
                product.getActive()
        );

    }
}
