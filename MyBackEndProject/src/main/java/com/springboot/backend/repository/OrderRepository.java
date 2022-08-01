package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springboot.backend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	
	@Query("select o from Order o where o.customer.id=?1")
	List<Order> getOrderByCustomerId(Long cid);
	
	
	@Query("select o from Order o where o.vendor.id=?1")
	List<Order> getOrderByVendorId(Long vid);

}