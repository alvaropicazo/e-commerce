package com.haase.ecommerce.user_service.controller;

import com.haase.ecommerce.user_service.dto.UserRequest;
import com.haase.ecommerce.user_service.dto.UserResponse;
import com.haase.ecommerce.user_service.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> register(@Valid @RequestBody UserRequest request) {
        try {
            UserResponse response = service.createUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch(RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
