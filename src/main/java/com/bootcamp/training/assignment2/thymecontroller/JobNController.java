//package com.bootcamp.training.assignment2.thymecontroller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import com.bootcamp.training.assignment2.model.Job;
//import com.bootcamp.training.assignment2.service.JobService;
//
//@Controller
//public class JobNController {
//	@Autowired
//	JobService jobService;
//
//    @GetMapping("/jobs")
//    public String getJobs(Model model) {
//        // Retrieve a list of jobs from a service layer or database
//        List<Job> jobs = jobService.findAll();
//        model.addAttribute("jobs", jobs);
//        return "jobs";
//    }
//
//    @GetMapping("/addJob")
//    public String addJob(Model model) {
//        model.addAttribute("job", new Job());
//        return "addJob";
//    }
//
//    @PostMapping("/addJob")
//    public String addJob(Job job) {
//        jobService.save(job);
//        return "redirect:/jobs";
//    }
//
//    @GetMapping("/deleteJob/{id}")
//    public String deleteJob(@PathVariable String id) {
//        jobService.deleteById(id);
//        return "redirect:/jobs";
//    }
//}
//
