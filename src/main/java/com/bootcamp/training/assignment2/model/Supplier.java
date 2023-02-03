package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Supplier {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorSupplier")
    @Type(type = "string")
    private String id;

    private String companyName;

    private String address;

    private long phoneNumber;

    @ManyToMany(mappedBy="suppliers")
    private List<Product> products;

    public Supplier(String id, String companyName, String address, long phoneNumber, List<Product> products) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

    public Supplier() {
    }

}

//The AtomicLong class provides a thread-safe way to increment a long value,
//which is used to generate unique identifier values in the generate method.

class UUIDGeneratorSupplier implements IdentifierGenerator {
    private static final AtomicLong counter = new AtomicLong(1);

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return "SUP00" + counter.getAndIncrement();
    }
}


