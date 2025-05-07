package com.bits.bitsdbsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(LocalDate now, double v, Customer customer) {
        this.orderDate = now;
        this.totalAmount = v;
        this.customer = customer;
    }

    public Order() {

    }
}

