package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class User_s {

	  @Id
	  @GeneratedValue(generator = "system-uuid")
	  @GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorUse")
	  @Type(type = "string")
	    private String id;

    private String userName;

    private String password;
    
    //private String emp_id;
    
   
//    @OneToOne(,cascade=CascadeType.ALL)
    @OneToOne(targetEntity=Employee.class,cascade=CascadeType.ALL)
    @JoinColumn(name="emp_id")
    private Employee emp;
//        
   


    


    

   



	public User_s() {
    }
public User_s(String id, String userName, String password, Employee emp) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.emp = emp;
}









	
	
	
	public void setPassword(String password) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    this.password = passwordEncoder.encode(password);
	}



}

class UUIDGeneratorUse implements IdentifierGenerator {
private static final AtomicLong counter = new AtomicLong(1);

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
return "U00" + counter.getAndIncrement();
}
}
