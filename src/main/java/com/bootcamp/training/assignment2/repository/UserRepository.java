package com.bootcamp.training.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.training.assignment2.model.User_s;
@Repository
public interface UserRepository extends JpaRepository<User_s,String>{

}
