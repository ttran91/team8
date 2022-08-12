package com.springboot.backend.GP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.GP.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}