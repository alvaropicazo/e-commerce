package com.haase.ecommerce.product_service.listener;

import com.haase.ecommerce.common.event.OrderPlacedEvent;
import com.haase.ecommerce.product_service.service.ProductService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderPlacedListener {

    private final ProductService productService;

    public OrderPlacedListener(ProductService productService) {
        this.productService = productService;
    }

    @KafkaListener(topics = "order.created", groupId = "product_service")
    public void handleOrderPlaced(OrderPlacedEvent event) {
        productService.reduceStock(event.getProductId(), event.getQuantity());
    }
}