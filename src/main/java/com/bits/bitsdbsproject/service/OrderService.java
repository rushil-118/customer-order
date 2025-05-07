package com.bits.bitsdbsproject.service;

import com.bits.bitsdbsproject.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public List<Order> getAllOrders();

    public void saveOrder(Order order);

    public Optional<Order> getOrderById(Long ID);

    public Order updateOrder(Long id, Order orderDetails);
}
