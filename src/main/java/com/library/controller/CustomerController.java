package com.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    
    @PatchMapping("/{id}/status")
    public ResponseEntity<Customer> updateCustomerStatus(@PathVariable Long id, @RequestBody String status) {
        Optional<Customer> existingCustomer = customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();

        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            // Verificação para permitir apenas "ACTIVE" ou "INACTIVE"
            if ("ACTIVE".equalsIgnoreCase(status) || "INACTIVE".equalsIgnoreCase(status)) {
                customer.setStatus(status.toUpperCase());
                return ResponseEntity.ok(customer);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
