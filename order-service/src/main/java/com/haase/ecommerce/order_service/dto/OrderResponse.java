package com.haase.ecommerce.order_service.dto;

import java.util.UUID;

public class OrderResponse {
    private UUID id;
    private String userId;
    private String productId;
    private int quantity;
    private String status;

    // Constructor, Getters
    public OrderResponse(UUID id, String userId, String productId, int quantity, String status) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
