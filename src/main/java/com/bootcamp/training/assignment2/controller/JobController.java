//package com.bootcamp.training.assignment2.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bootcamp.training.assignment2.model.Job;
//import com.bootcamp.training.assignment2.service.JobService;
//
//import java.util.*;
//
//@RestController
//public class JobController {
//	@Autowired
//	private JobService jobService;
//
//	@GetMapping("/jobs")
//	public List<Job> getAllJobs() {
//	    return jobService.findAll();
//	}
//
//	@GetMapping("/jobs/{id}")
//	public Optional<Job> getJobById(@PathVariable("id") long id) {
//	    return jobService.findById(id);
//	}
//
//	@PostMapping("/jobs")
//	public Job createJob(@RequestBody Job job) {
//	    return jobService.save(job);
//	}
//
//	@PutMapping("/jobs/{id}")
//	public Job updateJob(@PathVariable("id") long id, @RequestBody Job job) {
//	    return jobService.save( job);
//	}
//
//	@DeleteMapping("/jobs/{id}")
//	public void deleteJob(@PathVariable("id") String id) {
//	    jobService.deleteById(id);
//	}
//
//}
