package org.ampath.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ampath.model.Meal;
import org.ampath.model.Order;

public class DataStore {

	private List<Order> orders = new ArrayList<Order>();
	
	private static DataStore instance;
	
	static {
		populateOrders();
	}
	
	public static DataStore get() {
		
		if(instance == null)
			instance = new DataStore();
		
		return instance;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order order) {
		orders.add(0, order);
	}
	
	public void updateOrder(Order order) {
		
		for(int i = 0; i < orders.size(); i++) {
			
			Order o = orders.get(i);
			
			if(o.getId() == order.getId()) {
				
				orders.set(i, order);
				
//				o.setName(order.getName());
//				o.setRestaurant(order.getRestaurant());
//				o.setStatus(order.getStatus());
			}
		}
	}
	
	public Order findOrderById(long id) {
		
		for(int i = 0; i < orders.size(); i++) {
			
			Order o = orders.get(i);
			
			if(o.getId() == id)
				return o;
		}
		return null;
	}
	
	public void deleteOrder(Order order) {
		
		long id = order.getId();
		
		for(int i = 0; i < orders.size(); i++) {
			
			Order o = orders.get(i);
			
			if(o.getId() == id)
				orders.remove(o);
		}
	}
	
	public Meal findMealById(long id) {
		
		for(int i = 0; i < orders.size(); i++) {
			
			Order o = orders.get(i);
			
			List<Meal> meals = o.getMeals();
			
			for(int x = 0; x < meals.size(); x++) {
				
				Meal m = meals.get(x);
				
				if(m.getId() == id)
					return m;
			}
 		}	
		
		return null;
	}
	
	public void updateMeal(Meal meal) {
		
		Meal m = findMealById(meal.getId());
		
		if(m != null) {
			m.setCreatedBy(meal.getCreatedBy());
			m.setName(meal.getName());
			m.setPrice(meal.getPrice());
		}
	}
	
	public void addMeal(long orderId, Meal meal) {
		Order order = findOrderById(orderId);
		
		meal.setId(Meal.autoIncrementAndGetID());
		meal.setCreatedAt(new Date());
		order.getMeals().add(meal);
	}
	
	private static void populateOrders() {
		Order order = new Order();
		order.setName("Pizza Lunch");
		order.setRestaurant("Pizza Inn");
		
		Meal meal = new Meal();
		meal.setName("Meat Deluxe");
		meal.setCreatedBy("Vincent");
		meal.setPrice(950.00);
		order.getMeals().add(meal);
		
		DataStore.get().getOrders().add(order);
			
	}
}