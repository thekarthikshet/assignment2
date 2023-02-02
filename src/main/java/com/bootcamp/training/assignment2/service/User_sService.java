package com.bootcamp.training.assignment2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.training.assignment2.model.User_s;
import com.bootcamp.training.assignment2.repository.UserRepository;

@Service
public class User_sService {
	private final UserRepository userRepository;

    public User_sService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User_s> findAll() {
        return userRepository.findAll();
    }

    public Optional<User_s> findById(String id) {
        return userRepository.findById(id);
    }

    public User_s save(User_s user) {
        return userRepository.save(user);
    }
    

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
