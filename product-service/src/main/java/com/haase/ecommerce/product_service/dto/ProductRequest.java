package com.haase.ecommerce.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductRequest {
    @NotBlank
    private String productName;

    @NotBlank
    private String description;

    @Positive
    private int stock;

    @Positive
    private double price;

    // Getters and Setters
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductDescription() {
        return description;
    }
    public void setProductDescription(String description) {
        this.description = description;
    }
    
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
