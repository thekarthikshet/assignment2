package com.bootcamp.training.assignment2.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.training.assignment2.model.Job;
import com.bootcamp.training.assignment2.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Optional<Job> findById(String id) {
        return jobRepository.findById(id);
    }

    public Job save(Job job) {
        return jobRepository.save(job);
        
        
    }
    

    public void deleteById(String id) {
        jobRepository.deleteById(id);
    }
}
