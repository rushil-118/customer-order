package com.bits.bitsdbsproject;

import com.bits.bitsdbsproject.model.Customer;
import com.bits.bitsdbsproject.model.Order;
import com.bits.bitsdbsproject.repository.CustomerRepository;
import com.bits.bitsdbsproject.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testFindOrdersWithCustomers() {
        Customer customer = new Customer("Alice", "alice@example.com", "1231231234");
        customer = customerRepository.save(customer);

        Order order = new Order(LocalDate.now(), 150.0, customer);
        orderRepository.save(order);

        List<Order> results = orderRepository.findAllOrdersWithCustomer();
        assertThat(results).isNotEmpty();
        assertThat(results.get(0).getCustomer().getName()).isEqualTo("Alice");
    }
}