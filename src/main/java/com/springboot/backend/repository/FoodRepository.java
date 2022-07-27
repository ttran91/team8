package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
