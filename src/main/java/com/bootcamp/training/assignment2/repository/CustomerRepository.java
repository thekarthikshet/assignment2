package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bootcamp.training.assignment2.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,String>{

}
