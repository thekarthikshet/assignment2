package com.bootcamp.training.assignment2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
public class User {

    @Id
    private int id;

    private String userName;

    private String password;

    @OneToOne
    private Employee employee;

    public User(int id, String userName, String password, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.employee = employee;
    }
    

    public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    this.password = passwordEncoder.encode(password);
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public User() {
    }
}
