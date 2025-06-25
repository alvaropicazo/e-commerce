package com.haase.ecommerce.product_service.service;

import com.haase.ecommerce.product_service.dto.ProductRequest;
import com.haase.ecommerce.product_service.dto.ProductResponse;
import com.haase.ecommerce.product_service.model.Product;
import com.haase.ecommerce.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.UUID;
import java.util.List;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setStock(request.getStock());
        product.setPrice(request.getPrice());

        Product saved = repository.save(product);

        return new ProductResponse(saved.getId(), saved.getProductName(), saved.getProductDescription(), saved.getStock(), saved.getPrice());
    }

    public ProductResponse getProduct(UUID id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return new ProductResponse(product.getId(), product.getProductName(), product.getProductDescription(), product.getStock(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = repository.findAll();
        if (products.isEmpty()) {
            throw new RuntimeException("No products found");
        }
        return products.stream()
        .map(product -> new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getStock(),
                product.getPrice()
        ))
        .collect(Collectors.toList());
    }

    public void reduceStock(UUID productId, int quantity) {
        Product product = repository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStock(product.getStock() - quantity);

        repository.save(product);
    }
}
