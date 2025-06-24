package com.haase.ecommerce.product_service.repository;

import com.haase.ecommerce.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
