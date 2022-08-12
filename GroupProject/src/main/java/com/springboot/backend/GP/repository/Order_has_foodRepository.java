package com.springboot.backend.GP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.GP.model.Order_has_food;

public interface Order_has_foodRepository extends JpaRepository<Order_has_food, Long>{

    @Query("select r from Order_has_food r where r.food.id=?1")

    List<Order_has_food> getOrderHasFoodByFid(Long fid);


    @Query("select r from Order_has_food r where r.order.id=?1")
    List<Order_has_food> getOrderHasFoodByOid(Long oid);
	

}