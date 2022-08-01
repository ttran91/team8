package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}