package org.ampath.controller;

import java.util.List;

import org.ampath.model.Meal;
import org.ampath.model.Order;
import org.ampath.service.MealService;
import org.ampath.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealsController {

	@Autowired
	MealService mealService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/meal/create/{order_id}", method = RequestMethod.POST)
    public ResponseEntity<Void> createMeal(@PathVariable("order_id") long order_id, @RequestBody Meal meal) {
		
		Order order = orderService.findOrderById(order_id);
		
		if(order != null) {
			
			mealService.saveMeal(order, meal);
		} else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
		HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/meal/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> editOrder(@PathVariable("id") long id, @RequestBody Meal meal) {
		
		mealService.updateMeal(meal);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
