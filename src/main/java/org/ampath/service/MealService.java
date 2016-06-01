package org.ampath.service;

import java.util.Map;

import org.ampath.model.Meal;
import org.ampath.model.Order;

public interface MealService {

	Meal findMealById(long id);
	
	Map<String, Object> saveMeal(Order order, Meal meal);
	
	Map<String, Object> updateMeal(Meal meal);
	
	Map<String, Object> deleteMeal(long id);
	
	Map<String, Object> deleteAllMeals(Order order);
	
	boolean mealExists(Meal meal);
	
	boolean userHasOrdered(Order order, String user);
	
//Order findOrderById(long id);
//	
//	Order findOrderByRestaurant(String restaurant);
//	
//	Map<String, Object> saveOrder(Order order);
//	
//	Map<String, Object> updateOrder(Order order);
//	
//	Map<String, Object> deleteOrderById(long id);
//
//	Map<String, Object> deleteAllOrders();
//	
//	boolean orderExists(Order order);
}
