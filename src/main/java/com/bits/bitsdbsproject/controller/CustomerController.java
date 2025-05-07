package com.bits.bitsdbsproject.controller;

import com.bits.bitsdbsproject.model.Customer;
import com.bits.bitsdbsproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id).orElseThrow();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "updateCustomer";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute Customer customer) {
        customerService.updateCustomer(id, customer);
        return "redirect:/customers";
    }
}
