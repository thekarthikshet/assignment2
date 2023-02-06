package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
public class Product {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorProduct")
	@Type(type = "string")
	private String id;

    private String name;

    private Double price;

    private long thresholdQuantity;

    private long stockInHand;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        
            joinColumns = @JoinColumn(name = "product_id"))
            
    private List<Supplier> suppliers;

    public Product(String id, String name, Double price, long thresholdQuantity, long stockInHand, String description, List<Supplier> suppliers) {
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
class UUIDGeneratorProduct implements IdentifierGenerator {
	private static final AtomicLong counter = new AtomicLong(1);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return "PROD00" + counter.getAndIncrement()+"_" + new Date().getTime();
	}
}
