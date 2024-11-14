package com.library.repository;

import com.library.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.library")


public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return customers;
    }

    public Optional<Customer> findById(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Customer save(Customer customer) {
        findById(customer.getId()).ifPresent(customers::remove);
        customers.add(customer);
        return customer;
    }

    public void delete(Customer customer) {
        customers.remove(customer);
    }
}
