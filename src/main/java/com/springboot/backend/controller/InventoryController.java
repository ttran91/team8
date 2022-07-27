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
import com.springboot.backend.model.Inventory;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.FoodRepository;
import com.springboot.backend.repository.InventoryRepository;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/inventory")
	public List<Inventory> getAllInventories() {
		List<Inventory> list = inventoryRepository.findAll();
		return list;
	}
	
	@PostMapping("/inventory/{fid}/{vid}")
	public Inventory postInventory(@RequestBody Inventory inventory, @PathVariable("fid") Long fid,
			@PathVariable("vid") Long vid) {
		
		// go to repo and fetch food by fid
		Optional<Food> optional = foodRepository.findById(fid);
		if (!optional.isPresent())
			throw new RuntimeException("Food ID is Invalid!!");
		
		Food food = optional.get();
		
		// go to repo and fetch vendor by vid
		Optional<Vendor> optionalV = vendorRepository.findById(vid);
		if (!optional.isPresent())
			throw new RuntimeException("Vendor ID is Invalid!!");
		
		Vendor vendor = optionalV.get();
		
		// Attach food and category to the inventory
		inventory.setFood(food);
		inventory.setVendor(vendor);
		
		// Save the inventory in the DB
		return inventoryRepository.save(inventory);
	}

}
