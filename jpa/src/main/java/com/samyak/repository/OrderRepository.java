package com.samyak.repository;

import com.samyak.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);

    void deleteByOrderTrackingNumber(String orderTrackingNumber);
}
