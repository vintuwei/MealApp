package org.ampath.model;

import java.util.Date;

public class Meal {

	private static long auto_id = 0;
	
	private long id;
	
	private String name;
	
	private Double price;
	
	private Order order;
	
	private Date createdAt;
	
	public Meal() {
		this.id = autoIncrementAndGetID();
		this.createdAt = new Date();
	}
	
	public Meal(String name, Double price,Order order) {
		
		this();
		this.name = name;
		this.price = price;
		this.order = order;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	private long autoIncrementAndGetID() {
		auto_id+=1;
		return auto_id;
	}	
}