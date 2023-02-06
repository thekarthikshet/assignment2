package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Promotion {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorPromo")
	@Type(type = "string")
    private String id;

    private String productId;
    
    //@DateTimeFormat(pattern="YYYY-mm-DD")
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endDate;

    private double discount;

    public Promotion(String id, String productId, Date startDate, Date endDate, double discount) {
        this.id = id;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
    }

    public Promotion() {
    }
}
class UUIDGeneratorPromo implements IdentifierGenerator {
private static final AtomicLong counter = new AtomicLong(1);

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
return "PROM00" + counter.getAndIncrement()+"_" + new Date().getTime();
}
}
