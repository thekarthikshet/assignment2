package com.bootcamp.training.assignment2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.training.assignment2.model.User;
import com.bootcamp.training.assignment2.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
