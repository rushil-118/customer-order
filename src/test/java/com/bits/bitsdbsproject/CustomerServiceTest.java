package com.bits.bitsdbsproject;

import com.bits.bitsdbsproject.model.Customer;
import com.bits.bitsdbsproject.repository.CustomerRepository;
import com.bits.bitsdbsproject.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer sampleCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleCustomer = new Customer();
        sampleCustomer.setId(1L);
        sampleCustomer.setName("John Doe");
        sampleCustomer.setEmail("john@example.com");
        sampleCustomer.setPhoneNumber("1234567890");
    }

    @Test
    void testSaveCustomer() {
        when(customerRepository.save(sampleCustomer)).thenReturn(sampleCustomer);
        Customer saved = customerService.saveCustomer(sampleCustomer);
        assertEquals("John Doe", saved.getName());
        verify(customerRepository, times(1)).save(sampleCustomer);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = List.of(sampleCustomer);
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.getAllCustomers();
        assertEquals(1, result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomerById() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(sampleCustomer));

        Optional<Customer> found = customerService.getCustomerById(1L);
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
    }
}

