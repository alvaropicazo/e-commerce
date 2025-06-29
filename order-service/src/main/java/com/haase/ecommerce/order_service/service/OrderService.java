package com.haase.ecommerce.order_service.service;

import com.haase.ecommerce.order_service.dto.OrderRequest;
import com.haase.ecommerce.order_service.dto.OrderResponse;
import com.haase.ecommerce.order_service.model.Order;
import com.haase.ecommerce.order_service.repository.OrderRepository;
import com.haase.ecommerce.common.event.OrderPlacedEvent;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public OrderService(OrderRepository repository, KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public OrderResponse createOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setStatus("CREATED");

        Order saved = repository.save(order);
        kafkaTemplate.send("order.created", new OrderPlacedEvent(order.getId(), order.getProductId(), order.getQuantity()));

        return new OrderResponse(saved.getId(), saved.getUserId(), saved.getProductId(), saved.getQuantity(), saved.getStatus());
    }

    public OrderResponse getOrder(UUID id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return new OrderResponse(order.getId(), order.getUserId(), order.getProductId(), order.getQuantity(), order.getStatus());
    }
}
