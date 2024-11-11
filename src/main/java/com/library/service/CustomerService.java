package com.library.service;

import com.library.model.Customer;
import com.library.repository.CustomerRepository;
import com.library.exception.CustomerNotFoundException;
import java.util.List;


public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer customer = getCustomerById(id); // Lança exceção se o cliente não existir
        customer.setName(updatedCustomer.getName());
        customer.setLastname(updatedCustomer.getLastname());
        // Atualizar outros atributos conforme necessário
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id); // Lança exceção se o cliente não existir
        customerRepository.delete(customer);
    }

    public void updateCustomerStatus(Long id, String status) {
        Customer customer = getCustomerById(id);
        if ("ACTIVE".equalsIgnoreCase(status) || "INACTIVE".equalsIgnoreCase(status)) {
            customer.setStatus(status.toUpperCase());
            customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Invalid status value. Only 'ACTIVE' or 'INACTIVE' allowed.");
        }
    }
}
