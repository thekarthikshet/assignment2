package com.bootcamp.training.assignment2.controller;

import com.bootcamp.training.assignment2.model.Supplier;
import com.bootcamp.training.assignment2.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/supplier/{id}")
    public Optional<Supplier> getSupplierById(@PathVariable("id") String id) {
        return supplierService.findById(id);
    }

    @PostMapping("/supplier")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @PutMapping("/supplier/{id}")
    public Supplier updateSupplier(@PathVariable("id") String id, @RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @DeleteMapping("/supplier/{id}")
    public void deleteSupplier(@PathVariable("id") String id) {
        supplierService.deleteById(id);
    }

}
