package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.repository.OrderRepository;
import com.springboot.backend.model.Order;

@RestController //marking a class as controller

public class OrderController {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@PostMapping("/order")
	public void postOrderStatus(@RequestBody Order order) {
		// using JpaRepository Interface
		orderRepository.save(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		List<Order> list = orderRepository.findAll();
		
		return list;
		
	}
	
	@PutMapping("/order/{id}")
	public Order updateCategory(@PathVariable("id") Long id,
			@RequestBody Order newOrder) {
		Optional<Order> optional =orderRepository.findById(id);
		if(optional.isPresent()) {
			Order existingOrder =  optional.get();
			existingOrder.setOrderStatus(newOrder.getOrderStatus());
			existingOrder.setOrderCost(newOrder.getOrderCost());
			return orderRepository.save(existingOrder);
		}
		else	
			throw new RuntimeException("ID is invalid");
	}
	
	@GetMapping("/order/single/{id}")
	public Order getSingleOrderById(@PathVariable("id") Long id) {
		Optional <Order> optional = orderRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID in invalid");
		
	}
	
	@DeleteMapping("/order/single/{id}")
	public void deleteOrderStatus(@PathVariable("id") Long id) {
		orderRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}