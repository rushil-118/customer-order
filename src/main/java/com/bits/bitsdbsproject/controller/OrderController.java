package com.bits.bitsdbsproject.controller;

import com.bits.bitsdbsproject.model.Customer;
import com.bits.bitsdbsproject.model.Order;
import com.bits.bitsdbsproject.service.CustomerService;
import com.bits.bitsdbsproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "orders.jsp-form";
    }

    @PostMapping
    public String saveOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        model.addAttribute("customers", customerService.getAllCustomers());
        return "orders.jsp-form";
    }
}

