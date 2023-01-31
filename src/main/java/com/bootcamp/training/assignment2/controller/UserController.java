//package com.bootcamp.training.assignment2.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bootcamp.training.assignment2.model.User;
//import com.bootcamp.training.assignment2.service.UserService;
//
//
//@RestController
//public class UserController {
//
//        @Autowired
//        UserService userService;
//
//        @PostMapping(value = "/addUser")
//        public ResponseEntity<String> saveUser(@RequestBody User user) {
//             userService.saveUser(user);
//             
//             return  new ResponseEntity<String>( HttpStatus.CREATED);
//        }
//
////        @GetMapping(value="/get-all")
////        public ResponseEntity<String> getUsers() {
////
////            return userService.getUsers();
////        }
//
//}
