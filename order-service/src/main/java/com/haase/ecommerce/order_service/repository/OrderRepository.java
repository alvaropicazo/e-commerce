package com.haase.ecommerce.order_service.repository;

import com.haase.ecommerce.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
