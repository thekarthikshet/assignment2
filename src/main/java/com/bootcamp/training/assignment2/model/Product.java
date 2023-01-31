package com.bootcamp.training.assignment2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long price;

    private long thresholdQuantity;

    private long stockInHand;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> suppliers;

    public Product(long id, String name, long price, long thresholdQuantity, long stockInHand, String description, List<Supplier> suppliers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thresholdQuantity = thresholdQuantity;
        this.stockInHand = stockInHand;
        this.description = description;
        this.suppliers = suppliers;
    }

    public Product() {
    }
}
