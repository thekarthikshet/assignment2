//package com.bootcamp.training.assignment2.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bootcamp.training.assignment2.model.User_s;
//import com.bootcamp.training.assignment2.service.User_sService;
//
//@RestController
//public class User_sController {
//
//    private final User_sService user_sService;
//
//    public User_sController(User_sService user_sService) {
//        this.user_sService = user_sService;
//    }
//
//    @GetMapping("/users")
//    public List<User_s> findAll() {
//        return user_sService.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public Optional<User_s> findById(@PathVariable String id) {
//        return user_sService.findById(id);
//    }
//
//    @PostMapping("/users")
//    public User_s save(@RequestBody User_s user) {
//        return user_sService.save(user);
//    }
//
//    @PutMapping("/users/{id}")
//    public User_s update(@PathVariable String id, @RequestBody User_s user) {
//        user.setId(id);
//        return user_sService.save(user);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteById(@PathVariable String id) {
//        user_sService.deleteById(id);
//    }
//}
