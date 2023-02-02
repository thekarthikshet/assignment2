package com.bootcamp.training.assignment2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Demo {
	public Demo(String idn, String name) {
		super();
		this.idn = idn;
		this.name = name;
	}
	@Id
private String idn ;
private String name;
}
