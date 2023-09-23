package com.samyak.service;

import com.samyak.entity.Order;
import com.samyak.repository.AddressRepository;
import com.samyak.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Transactional
    public Order saveOrderDetails(Order order){

        return orderRepository.save(order);
    }

    @Transactional
    public List<Order> saveAllOrderDetails(List<Order> orders){
        return orderRepository.saveAll(orders);
    }

    @Transactional
    public Order updateOrderDetails(String orderTrackingNumber, Order order) {
        Order savedOrder = orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
        savedOrder.setStatus(order.getStatus());
        savedOrder.setBillingAddress(order.getBillingAddress());
        savedOrder.setTotalPrice(order.getTotalPrice());
        savedOrder.setTotalQuantity(order.getTotalQuantity());

        return orderRepository.save(savedOrder);
    }

    public Order findByOrderTrackingNumber(String orderTrackingNumber) {
        return orderRepository.findByOrderTrackingNumber(orderTrackingNumber);
    }

    @Transactional
    public void deleteOrder(String orderTrackingNumber) {
        orderRepository.deleteByOrderTrackingNumber(orderTrackingNumber);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
