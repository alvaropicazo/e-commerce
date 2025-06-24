package com.haase.ecommerce.product_service.controller;

import com.haase.ecommerce.product_service.dto.ProductRequest;
import com.haase.ecommerce.product_service.dto.ProductResponse;
import com.haase.ecommerce.product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponse create(@Valid @RequestBody ProductRequest request) {
        return service.createProduct(request);
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse get(@PathVariable UUID id) {
        return service.getProduct(id);
    }
}
