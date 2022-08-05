package com.springboot.backend.GP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.GP.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
