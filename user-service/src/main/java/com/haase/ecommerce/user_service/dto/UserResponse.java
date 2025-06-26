package com.haase.ecommerce.user_service.dto;

import java.util.UUID;

public class UserResponse {
    private String username;

    public UserResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}