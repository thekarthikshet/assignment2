package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.training.assignment2.model.Product;

public interface ProductRepository extends JpaRepository<Product,String> {

}
