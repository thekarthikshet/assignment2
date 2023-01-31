package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    private String id;

    private String firstName;

    private String lastName;

    private String address;

    private long phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Job job;

    public Employee(String id, String firstName, String lastName, String address, long phoneNumber, Job job) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.job = job;
    }

    public Employee() {
    }
}
class UUIDGeneratorEmp implements IdentifierGenerator {
private static final AtomicLong counter = new AtomicLong(1);
 
@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
return "CUST00" + counter.getAndIncrement();
}
}