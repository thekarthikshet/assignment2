package com.bootcamp.training.assignment2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.training.assignment2.model.Customer;
import com.bootcamp.training.assignment2.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
        
        
    }
    

    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }
}
