package org.ampath.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private static long auto_id = 0;
	
	private long id;
	
	private String name;
	
	private String restaurant;
	
	private Date createdAt;
	
	private String status = "Ordered";
	
	private String createdBy;
	
	List<Meal> meals;
	
	public Order() {
		this.id = autoIncrementAndGetID();
		this.createdAt = new Date();
		this.meals = new ArrayList<Meal>();
	}
	
	public Order(String name, String restaurant, String status) {
		
		this();
		this.restaurant = restaurant;
		this.createdAt = new Date();
		this.status = status;
	}
	
	public Order(String name, String restaurant, String status, String createdBy) {
		this(name, restaurant, status);
		this.createdBy = createdBy;
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

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private long autoIncrementAndGetID() {
		
		auto_id+=1;
		return auto_id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<Meal> getMeals() {
		return meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}