package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Employee {

	  @Id
	  @GeneratedValue(generator = "system-uuid")
	  @GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorEmp")
	  @Type(type = "string")
    private String emp_id;

    private String firstName;

    private String lastName;

    private String address;
    
    private String job_id;

    private long phoneNumber;
    
   private String user_id;
//    @JoinColumn(name="emp_id",referencedColumnName="id")
    

//    @ManyToOne(targetEntity=Job.class,cascade = CascadeType.MERGE ) //cascade = CascadeType.ALL
//        private Job job;

 
     
    public Employee() {
    }


	public Employee(String emp_id, String firstName, String lastName, String address, String job_id, long phoneNumber,
			String user_s) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.job_id = job_id;
		this.phoneNumber = phoneNumber;
		this.user_id = user_s;
	}



	
}
class UUIDGeneratorEmp implements IdentifierGenerator {
private static final AtomicLong counter = new AtomicLong(1);
 
@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
return "EMP00" + counter.getAndIncrement()+"_" + new Date().getTime();
}
}