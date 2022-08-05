package com.springboot.backend.GP.dto;

import java.util.List;

public class VendorDto {
	private Long id; 
	private String name;
	private Integer numOfFood;
	
	List<FoodDto> food;

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

	public List<FoodDto> getFood() {
		return food;
	}

	public void setFood(List<FoodDto> food) {
		this.food = food;
	}

}
