package com.bits.bitsdbsproject.service;

import com.bits.bitsdbsproject.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public Customer saveCustomer(Customer customer);

    public Optional<Customer> getCustomerById(Long id);

    public Customer updateCustomer(Long id, Customer customerDetails);
}
