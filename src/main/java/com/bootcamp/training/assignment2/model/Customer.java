package com.bootcamp.training.assignment2.model;


import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.*;

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
public class Customer {

	 @Id
	  @GeneratedValue(generator = "system-uuid")
	  @GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorCus")
	  @Type(type = "string")
    private String id;
    private String name;
    private String address;
    private long phone;

    public Customer(String customerId, String name, String address, long phone) {
        this.id = customerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Customer() {
    }
}

class UUIDGeneratorCus implements IdentifierGenerator {
private static final AtomicLong counter = new AtomicLong(1);

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
return "CUST00" + counter.getAndIncrement();
}
}
