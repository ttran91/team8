package com.springboot.backend.GP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.GP.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
