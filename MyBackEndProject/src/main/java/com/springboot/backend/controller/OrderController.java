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

import com.springboot.backend.repository.CustomerRepository;
import com.springboot.backend.repository.OrderRepository;
import com.springboot.backend.repository.VendorRepository;
import com.springboot.backend.model.Customer;
import com.springboot.backend.model.Order;
import com.springboot.backend.model.Vendor;

@RestController //marking a class as controller

public class OrderController {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	
	
	@PostMapping("/order/{cid}/{vid}")
	public Order postOrder(@RequestBody Order order, 
						   @PathVariable("cid") Long cid,
						   @PathVariable("vid") Long vid) {

		Optional<Customer> optional = customerRepository.findById(cid);
		if (!optional.isPresent())
			throw new RuntimeException("Customer ID is Invalid!!");

		Customer customer = optional.get();

		Optional<Vendor> optionalV = vendorRepository.findById(vid);
		
		if(!optionalV.isPresent())
			throw new RuntimeException("Vendor ID is Invalid!!");
		
		Vendor vendor = optionalV.get();
		
		
		order.setCustomer(customer);
		order.setVendor(vendor);
		
		return orderRepository.save(order);
		
	}
	
	
	@PostMapping("/order/vendor/{vid}")
	public void postOrderByVendorId(@RequestBody Order order,
									@PathVariable("vid") Long vid) {

		Optional<Vendor> optional = vendorRepository.findById(vid);
		if (!optional.isPresent())
			throw new RuntimeException("Vendor ID is Invalid!!");
		
		Vendor vendor = optional.get();
		
		order.setVendor(vendor);
		
		orderRepository.save(order);
	}
	
	
	
	@PostMapping("/order/customer/{cid}")
	public void postOrderByCustomerId(@RequestBody Order order,
									  @PathVariable("cid") Long cid) {

		
		Optional<Customer> optional = customerRepository.findById(cid);
		if (!optional.isPresent())
			throw new RuntimeException("Customer ID is Invalid!!");
		
		Customer customer = optional.get();
		
		order.setCustomer(customer);
		
		orderRepository.save(order);
	}
	
	
	
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		List<Order> list = orderRepository.findAll();
		
		return list;
		
	}
	
	@GetMapping("/order/customer/{cid}")
	public List<Order> getOrderByCustomerId(@PathVariable("cid") Long cid){
		List<Order> list = orderRepository.getOrderByCustomerId(cid);
		return list;
	}
	
	@GetMapping("/order/vendor/{vid}")
	public List<Order> getOrderByVendorId(@PathVariable("vid") Long vid){
		List<Order> list = orderRepository.getOrderByVendorId(vid);
		return list;
	}
	
	@GetMapping("/order/single/{id}")
	public Order getSingleOrderById(@PathVariable("id") Long id) {
		Optional <Order> optional = orderRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID in invalid");
		
	}
	
	@PutMapping("/order/{id}")
	public Order updateOrderById(@PathVariable("id") Long id,
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
	

	
	@DeleteMapping("/order/single/{id}")
	public void deleteOrderById(@PathVariable("id") Long id) {
		orderRepository.deleteById(id);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

