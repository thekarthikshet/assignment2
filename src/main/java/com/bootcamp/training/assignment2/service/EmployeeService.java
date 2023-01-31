package com.bootcamp.training.assignment2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bootcamp.training.assignment2.model.Employee;
import com.bootcamp.training.assignment2.model.Job;
import com.bootcamp.training.assignment2.repository.EmployeeRepository;
import com.bootcamp.training.assignment2.repository.JobRepository;
@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository= employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee ) {
        return employeeRepository.save(employee);
        
        
    }
    

    public void deleteById(String id) {
    	employeeRepository.deleteById(id);
    }
}
