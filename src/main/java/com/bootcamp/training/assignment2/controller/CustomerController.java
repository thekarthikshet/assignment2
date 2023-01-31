package com.bootcamp.training.assignment2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.bootcamp.training.assignment2.model.Customer;
import com.bootcamp.training.assignment2.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
  
  private CustomerService customerService;
  
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }
  
  @GetMapping
  public List<Customer> getCustomers() {
    return customerService.findAll();
  }
  
  @GetMapping("/{id}")
  public Optional<Customer> getCustomer(@PathVariable String id) {
    return customerService.findById(id);
  }
  
  @PostMapping
  public Customer addCustomer(@RequestBody Customer customer) {
    return customerService.save(customer);
  }
  
  @PutMapping("/{id}")
  public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
    return customerService.save( customer);
  }
  
  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable String id) {
    customerService.deleteById(id);
  }
}

