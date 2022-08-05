package com.springboot.backend.GP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.GP.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long> {

}
