package com.bootcamp.training.assignment2.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long productId;
    
    private Date startDate;

    private Date endDate;

    private double discount;

    public Promotion(long id, long productId, Date startDate, Date endDate, double discount) {
        this.id = id;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public Promotion() {
    }
}
