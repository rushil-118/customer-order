package com.bits.bitsdbsproject.service;

import com.bits.bitsdbsproject.model.Order;
import com.bits.bitsdbsproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public void saveOrder(Order order) {
        repository.save(order);
    }

    public Optional<Order> getOrderById(Long Id) {
        return repository.findById(Id);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderDate(orderDetails.getOrderDate());
        order.setTotalAmount(orderDetails.getTotalAmount());
        return repository.save(order);
    }
}
