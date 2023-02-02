package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.training.assignment2.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{

}
