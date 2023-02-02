package com.bootcamp.training.assignment2.repository;

import com.bootcamp.training.assignment2.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,String> {
}
