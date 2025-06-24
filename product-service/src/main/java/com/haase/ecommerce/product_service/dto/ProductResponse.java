package com.haase.ecommerce.product_service.dto;


import java.util.UUID;

public class ProductResponse {
    private UUID id;
    private String productName;
    private String description;
    private int stock;
    private double price;

    // Constructor, Getters
    public ProductResponse(UUID id, String productName, String description, int stock, double price) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductDescription() {
        return description;
    }
    public void setProductDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
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
