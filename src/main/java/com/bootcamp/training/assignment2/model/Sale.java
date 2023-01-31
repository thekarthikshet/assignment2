package com.bootcamp.training.assignment2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Embeddable
 class SaleIdentity implements Serializable {

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long saleId;

    @ManyToOne
    private Product product;
}
@Getter
@Setter
@Entity
public class Sale {
    @EmbeddedId
    private SaleIdentity identity;
    private long quantity;

    public Sale(SaleIdentity identity, long quantity) {
        this.identity = identity;
        this.quantity = quantity;
    }

    public Sale() {
    }
}
