package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Order_has_food;

public interface Order_has_foodRepository extends JpaRepository<Order_has_food, Long>{
	

}