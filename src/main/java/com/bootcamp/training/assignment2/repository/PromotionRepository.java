package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.training.assignment2.model.Product;
import com.bootcamp.training.assignment2.model.Promotion;
@Repository
public interface PromotionRepository extends CrudRepository<Promotion,String> {
	
	Promotion findByProductId(String productId);
	
	
	
}
