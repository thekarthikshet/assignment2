package com.bootcamp.training.assignment2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;

    private String address;

    private long phoneNumber;

    @ManyToMany(mappedBy="suppliers")
    private List<Product> products;

    public Supplier(long id, String companyName, String address, long phoneNumber, List<Product> products) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.products = products;
    }

    public Supplier() {
    }
}
