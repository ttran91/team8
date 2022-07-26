package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}