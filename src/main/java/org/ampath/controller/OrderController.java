package org.ampath.controller;

import java.util.List;
import org.ampath.model.Order;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/orders")
    public ResponseEntity<List<Order>> listAllOrders() {
		
		return new ResponseEntity<List<Order>>(orderService.getOrders(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Void> createOrder(@RequestBody Order order,    UriComponentsBuilder ucBuilder) {
        orderService.saveOrder(order);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> editOrder(@PathVariable("id") long id, @RequestBody Order order) {
		
		Order o = orderService.findOrderById(id);
		
		if (o == null) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
 
        o.setName(order.getName());
        o.setRestaurant(order.getRestaurant());
        o.setStatus(order.getStatus());
         
        orderService.updateOrder(o);
        return new ResponseEntity<Order>(o, HttpStatus.OK);
    }
}