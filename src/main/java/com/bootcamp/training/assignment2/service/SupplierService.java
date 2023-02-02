package com.bootcamp.training.assignment2.service;

import com.bootcamp.training.assignment2.model.Job;
import com.bootcamp.training.assignment2.model.Supplier;
import com.bootcamp.training.assignment2.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierService {


    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findById(String id) {
        return supplierRepository.findById(id);
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    public void deleteById(String id) {
        supplierRepository.deleteById(id);
    }

}
