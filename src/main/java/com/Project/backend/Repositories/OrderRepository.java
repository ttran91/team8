package com.Project.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.backend.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
