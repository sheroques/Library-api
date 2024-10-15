package com.library.controller;

import org.springframework.web.bind.annotation.*;

import com.library.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customers.stream().filter(c -> c.getId().equals(id)).findFirst();
        existingCustomer.ifPresent(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setLastname(updatedCustomer.getLastname());
           
        });
        return existingCustomer.orElse(null);
    }

    
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }
}
