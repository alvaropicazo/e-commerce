package com.haase.ecommerce.product_service.model;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String productName;
    private String description;
    private int stock;
    private double price;

    // Getters and Setters
    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setProductDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public String getProductDescription() {
        return description;
    }
}

