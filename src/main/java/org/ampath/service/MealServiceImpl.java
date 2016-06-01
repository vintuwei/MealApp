package org.ampath.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.ampath.model.Meal;
import org.ampath.model.Order;
import org.ampath.utils.DataStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("mealService")
@Transactional
public class MealServiceImpl implements MealService {
	
	private static List<Meal> meals = new ArrayList<Meal>();
	
	@Override
	public Meal findMealById(long id) {
		
		return DataStore.get().findMealById(id);
	}

	@Override
	public Map<String, Object> saveMeal(Order order, Meal meal) {
		
		DataStore.get().addMeal(order.getId(), meal);
		return null;
	}

	@Override
	public Map<String, Object> updateMeal(Meal meal) {
		DataStore.get().updateMeal(meal);
		return null;
	}

	@Override
	public Map<String, Object> deleteMeal(long id) {
		//TODO implement
		return null;
	}

	@Override
	public Map<String, Object> deleteAllMeals(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean mealExists(Meal meal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userHasOrdered(Order order, String user) {
		
		
		
		return false;
	}

}
