package com.haase.ecommerce.order_service.controller;

import com.haase.ecommerce.order_service.dto.OrderRequest;
import com.haase.ecommerce.order_service.dto.OrderResponse;
import com.haase.ecommerce.order_service.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderResponse create(@Valid @RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping("/{id}")
    public OrderResponse get(@PathVariable UUID id) {
        return service.getOrder(id);
    }
}
