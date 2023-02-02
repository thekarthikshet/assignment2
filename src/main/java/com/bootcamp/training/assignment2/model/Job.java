package com.bootcamp.training.assignment2.model;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class Job {

	
	
	  @Id
	  @GeneratedValue(generator = "system-uuid")
	  @GenericGenerator(name = "system-uuid", strategy = "com.bootcamp.training.assignment2.model.UUIDGenerator")
	  @Type(type = "string")
	      private String id;

    private String title;

    private long salary;
    @OneToMany(targetEntity=Employee.class,cascade=CascadeType.ALL)
    @JoinColumn(name="job_id",referencedColumnName="id")
    private List<Employee> employees;   


    

    public Job() {
    }

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", salary=" + salary + "]";
	}




	public Job(String id, String title, long salary, List<Employee> employees) {
		super();
		this.id = id;
		this.title = title;
		this.salary = salary;
		this.employees = employees;
	}
   
}

//The AtomicLong class provides a thread-safe way to increment a long value,
//which is used to generate unique identifier values in the generate method.
class UUIDGenerator implements IdentifierGenerator {
private static final AtomicLong counter = new AtomicLong(1);

@Override
public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
return "JOB00" + counter.getAndIncrement();
}
}

