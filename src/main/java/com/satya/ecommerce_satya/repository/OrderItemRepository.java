package com.satya.ecommerce_satya.repository;

import com.satya.ecommerce_satya.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
