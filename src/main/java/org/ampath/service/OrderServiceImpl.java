package org.ampath.service;

import java.util.List;
import org.ampath.model.Order;
import org.ampath.utils.DataStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
		
	@Override
	public List<Order> getOrders() {
		return DataStore.get().getOrders();
	}

	@Override
	public Order findOrderById(long id) {
		return DataStore.get().findOrderById(id);
	}

	@Override
	public void saveOrder(Order order) {
		DataStore.get().addOrder(order);
	}

	@Override
	public void updateOrder(Order order) {
		
		if(order != null) {
			
			DataStore.get().updateOrder(order);
		}
	}

	@Override
	public void deleteOrderById(long id) {
		
		Order order = DataStore.get().findOrderById(id);
		
		if(order != null)
			DataStore.get().deleteOrder(order);
	}
}