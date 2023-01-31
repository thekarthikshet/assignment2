package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.training.assignment2.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

}
