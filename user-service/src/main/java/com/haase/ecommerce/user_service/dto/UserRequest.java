package com.haase.ecommerce.user_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

public class UserRequest {
    @NotBlank
    private String username;

    @Positive
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
