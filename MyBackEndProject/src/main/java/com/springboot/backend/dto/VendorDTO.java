package com.springboot.backend.dto;

import java.util.List;

public class VendorDTO {
	private Long id; 
	private String name;
	private Integer numOfFood;
	
	List<FoodDTO> food;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumOfFood() {
		return numOfFood;
	}

	public void setNumOfFood(Integer numOfFood) {
		this.numOfFood = numOfFood;
	}

	public List<FoodDTO> getFood() {
		return food;
	}

	public void setFood(List<FoodDTO> food) {
		this.food = food;
	}

	
	
	
	
}