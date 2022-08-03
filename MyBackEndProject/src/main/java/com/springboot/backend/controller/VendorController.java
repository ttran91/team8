package com.springboot.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.FoodDTO;
import com.springboot.backend.dto.VendorDTO;
import com.springboot.backend.model.Food;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.FoodRepository;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private FoodRepository foodRepository; 
	
	@PostMapping("/vendor")
	public void postVendor(@RequestBody Vendor vendor) {
		vendorRepository.save(vendor);
	}
	
	@GetMapping("/vendor")
	public List<VendorDTO> getAllVendors(
			@RequestParam(name = "page",required = false, defaultValue = "0") Integer page, 
			@RequestParam(name = "size",required = false, defaultValue = "100000") Integer size ) {
		
		Pageable pageable=PageRequest.of(page, size);
		List<Vendor>  list = vendorRepository.findAll(pageable).getContent(); //20
		List<VendorDTO> listVDto = new ArrayList<>();
		
		List<Food> listFood = foodRepository.findAll();
		
		list.stream().forEach(v->{
			List<FoodDTO> listFDto = new ArrayList<>(); 
			VendorDTO vDto = new VendorDTO(); 
			vDto.setId(v.getId());
			vDto.setName(v.getName());
			List<Food> filteredList = listFood.stream()
						.filter(f-> f.getVendor().getId().equals(v.getId()))
						.collect(Collectors.toList());
			vDto.setNumOfFood(filteredList.size());
			filteredList.stream().forEach(f->{
				FoodDTO dto = new FoodDTO(); 
				dto.setId(f.getId());
				dto.setName(f.getName());
				dto.setFoodPrice(f.getFoodPrice());
				dto.setFoodCategory(f.getFoodCategory());
				dto.setVid(f.getVendor().getId());
				dto.setVname(f.getVendor().getName());
				dto.setVphoneNumber(f.getVendor().getPhoneNumber());
				dto.setVemail(f.getVendor().getEmail());
				listFDto.add(dto);
			});
			vDto.setFood(listFDto);
			listVDto.add(vDto);
		});
		return listVDto; 
	}
	
	@GetMapping("/vendor/{id}") 
	public Vendor getVendorById(@PathVariable("id") Long id) { 
		Optional<Vendor> optional = vendorRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		else
			throw new RuntimeException("ID is invalid");
	}
	
	@DeleteMapping("/vendor/{id}")
	public void deleteVendor(@PathVariable("id") Long id){
		vendorRepository.deleteById(id);
		
	}
}








