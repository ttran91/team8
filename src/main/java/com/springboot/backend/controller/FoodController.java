package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Food;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.FoodRepository;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private VendorRepository vendorRepository;
	
	//List all the data to the user
	@GetMapping("/food")
	public List<Food> getAllFood(){
		List<Food> list = foodRepository.findAll();
		return list;
	}
	
	@PostMapping("/food/{vid}")
	public Food postFood(@RequestBody Food food, @PathVariable("vid") Long vid) {
		// Go to repo and fetch 
		Optional<Vendor> optional = vendorRepository.findById(vid);
		
		if(!optional.isPresent())
			throw new RuntimeException("Vendor ID is Invalid!!");
		
		Vendor vendor;
		vendor = optional.get();
		
		food.setVendor(vendor);
		
		//Save the product
		return foodRepository.save(food);
		
		
	}
	
	
	
	
}
