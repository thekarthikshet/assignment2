package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.bootcamp.training.assignment2.repository.ProductRepository;


import lombok.Getter;
import lombok.Setter;
//@Getter
//@Setter
//@Embeddable
//class SaleIdentity implements Serializable {
//
//
//    @Column(nullable = false)
//    private long saleId;
//
//    @ManyToOne
//    private Product product;
//}

@Getter
@Setter
@Entity
public class Sale {
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGeneratorSale")
	@Type(type = "string")
    private String id;
    private long phoneNumber;
    private long quantity;
    private String product_id;
    private Double discount;
    private Double price;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date saleDate;
    private Double netPrice;
   
    



    public Sale() {
    }




	public Sale(String id, long phoneNumber, long quantity, String product_id, Double discount, Double price,
			Date saleDate, Double netPrice) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.quantity = quantity;
		this.product_id = product_id;
		this.discount = discount;
		this.price = price;
		this.saleDate = saleDate;
		this.netPrice = netPrice;
	}








	
}

class UUIDGeneratorSale implements IdentifierGenerator {
	private static final AtomicLong counter = new AtomicLong(1);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return "SALE00" + counter.getAndIncrement()+"_" + new Date().getTime();
	}
}



