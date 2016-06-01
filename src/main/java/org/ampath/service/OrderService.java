package org.ampath.service;

import java.util.List;

import org.ampath.model.Order;

public interface OrderService {
	
	List<Order> getOrders();
	
	Order findOrderById(long id);
		
	void saveOrder(Order order);
	
	void updateOrder(Order order);
	
	void deleteOrderById(long id);
		
}
