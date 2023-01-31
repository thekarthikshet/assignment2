package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.training.assignment2.model.Job;
@Repository
public interface JobRepository extends JpaRepository<Job,String>{

}
