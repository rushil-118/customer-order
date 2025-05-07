package com.bits.bitsdbsproject.service;

import com.bits.bitsdbsproject.model.Customer;
import com.bits.bitsdbsproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> customer = getCustomerById(id);
        customer.get().setName(customerDetails.getName());
        customer.get().setEmail(customerDetails.getEmail());
        customer.get().setPhoneNumber(customerDetails.getPhoneNumber());
        return repository.save(customer.get());
    }
}
