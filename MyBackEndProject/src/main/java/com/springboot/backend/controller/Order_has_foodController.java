<<<<<<< HEAD
package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Food;
import com.springboot.backend.model.Order;
import com.springboot.backend.model.Order_has_food;
import com.springboot.backend.repository.FoodRepository;
import com.springboot.backend.repository.OrderRepository;
import com.springboot.backend.repository.Order_has_foodRepository;

@RestController
public class Order_has_foodController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private Order_has_foodRepository OrderHasFoodRepository;
	
	
	
	@PostMapping("/OrderHasFood/{oid}/{fid}")
	public Order_has_food postOrder_has_food(@RequestBody Order_has_food OrderHasFood, 
											@PathVariable("oid") Long oid,
											@PathVariable("fid") Long fid) {

		Optional<Order> optionalO = orderRepository.findById(oid);
		if (!optionalO.isPresent())
			throw new RuntimeException("Order ID is Invalid!!");

		Optional<Food> optionalF = foodRepository.findById(fid);
		
		if(!optionalF.isPresent())
			throw new RuntimeException("Food ID is Invalid!!");
		
		Order order = optionalO.get();
		Food food = optionalF.get();
		
		OrderHasFood.setOrder(order);
		OrderHasFood.setFood(food);
	
		return OrderHasFoodRepository.save(OrderHasFood);
	}
	
	@GetMapping("/ordersHasFood")
	public List<Order_has_food> getAllOrderHasFood(){
		List<Order_has_food> list = OrderHasFoodRepository.findAll();
		
		return list;
		
	}
	
	@GetMapping("/orderHasFood/food/{fid}")
	public List<Order_has_food> getOrderHasFoodByFid(@PathVariable("fid") Long fid){
		List<Order_has_food> list = OrderHasFoodRepository.getOrderHasFoodByFid(fid);
		return list;
	}
	
	
	@GetMapping("/orderHasFood/order/{oid}")
	public List<Order_has_food> getOrderHasFoodByOid(@PathVariable("Oid") Long Oid){
		List<Order_has_food> list = OrderHasFoodRepository.getOrderHasFoodByOid(Oid);
		return list;
	}
	
	
	@DeleteMapping("/OrderHasFood/{id}")
	public void OrderHasFood(@PathVariable("id")Long id){
		OrderHasFoodRepository.deleteById(id);
		
	}
	
	






























}
=======
package com.springboot.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.backend.model.Food;
import com.springboot.backend.model.Order;
import com.springboot.backend.model.Order_has_food;
import com.springboot.backend.repository.FoodRepository;
import com.springboot.backend.repository.OrderRepository;
import com.springboot.backend.repository.Order_has_foodRepository;

@RestController
public class Order_has_foodController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private Order_has_foodRepository OrderHasFoodRepository;
	
	
	
	@PostMapping("/OrderHasFood/{oid}/{fid}")
	public Order_has_food postOrder_has_food(@RequestBody Order_has_food OrderHasFood, 
											@PathVariable("oid") Long oid,
											@PathVariable("fid") Long fid) {

		Optional<Order> optionalO = orderRepository.findById(oid);
		if (!optionalO.isPresent())
			throw new RuntimeException("Order ID is Invalid!!");

		Optional<Food> optionalF = foodRepository.findById(fid);
		
		if(!optionalF.isPresent())
			throw new RuntimeException("Food ID is Invalid!!");
		
		Order order = optionalO.get();
		Food food = optionalF.get();
		
		OrderHasFood.setOrder(order);
		OrderHasFood.setFood(food);
	
		return OrderHasFoodRepository.save(OrderHasFood);
	}
	

}
>>>>>>> e07ce64942879082a08a18d24f5f54e71def72cb
