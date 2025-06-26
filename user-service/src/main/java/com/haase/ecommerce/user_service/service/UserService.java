package com.haase.ecommerce.user_service.service;

import com.haase.ecommerce.user_service.dto.UserRequest;
import com.haase.ecommerce.user_service.dto.UserResponse;
import com.haase.ecommerce.user_service.model.User;
import com.haase.ecommerce.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest request) {
        if (repository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User(UUID.randomUUID(), request.getUsername(), passwordEncoder.encode(request.getPassword()));

        User saved = repository.save(user);

        return new UserResponse(user.getUsername());
    }
}
