package com.haase.ecommerce.order_service.service;

import com.haase.ecommerce.order_service.dto.OrderRequest;
import com.haase.ecommerce.order_service.dto.OrderResponse;
import com.haase.ecommerce.order_service.model.Order;
import com.haase.ecommerce.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setStatus("CREATED");

        Order saved = repository.save(order);

        return new OrderResponse(saved.getId(), saved.getUserId(), saved.getProductId(), saved.getQuantity(), saved.getStatus());
    }

    public OrderResponse getOrder(UUID id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrderResponse(order.getId(), order.getUserId(), order.getProductId(), order.getQuantity(), order.getStatus());
    }
}
