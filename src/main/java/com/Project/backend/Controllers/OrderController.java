package com.Project.backend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.backend.Repositories.OrderRepository;
import com.Project.backend.models.Order;

@RestController //marking a class as controller

public class OrderController {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@PostMapping("/orderStatus")
	public void postOrderStatus(@RequestBody Order order) {
		// using JpaRepository Interface
		orderRepository.save(order);
	}
	
	@GetMapping("/orderStatus")
	public List<Order> getAllOrders(){
		List<Order> list = orderRepository.findAll();
		
		return list;
		
	}
	
	@GetMapping("/orderStatus/{id}")
	public Order getSingleOrderById(@PathVariable("id") Long id) {
		Optional <Order> optional = orderRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID in invalid");
		
	}
	
	@DeleteMapping("/orderStatus/{id}")
	public void deleteOrderStatus(@PathVariable("id") Long id) {
		orderRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
