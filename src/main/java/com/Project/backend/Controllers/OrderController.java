package com.Project.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.backend.Repositories.OrderRepository;
import com.Project.backend.models.Order;

@RestController //marking a class as controller

public class OrderController {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@PostMapping("/order")
	public void postOrder(@RequestBody Order order) {
		// using JpaRepository Interface
		orderRepository.save(order);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
