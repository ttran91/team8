package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.springboot.backend.enums.CouponCode;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	//Make sure foodCategory is not NULL
	@Column(nullable = false)
	private String foodCategory;
	//Make sure foodPrice is not NULL
	@Column(nullable = false)
	private double foodPrice;
	@Column(nullable = false)
	private String name;
	//Vendor ID as a foreign key
	@OneToOne
	private Vendor vendor;

	private LocalDate dateOfPurchase;
	
	private Boolean coupon_used;
	
	@Enumerated(EnumType.STRING)
	private CouponCode coupon_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Boolean getCoupon_used() {
		return coupon_used;
	}

	public void setCoupon_used(Boolean coupon_used) {
		this.coupon_used = coupon_used;
	}

	public CouponCode getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(CouponCode coupon_code) {
		this.coupon_code = coupon_code;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", foodCategory=" + foodCategory + ", foodPrice=" + foodPrice + ", name=" + name
				+ ", vendor=" + vendor + ", dateOfPurchase=" + dateOfPurchase + ", coupon_used=" + coupon_used
				+ ", coupon_code=" + coupon_code + "]";
	}

	public Food(Long id, String foodCategory, double foodPrice, String name, Vendor vendor, LocalDate dateOfPurchase,
			Boolean coupon_used, CouponCode coupon_code) {
		super();
		this.id = id;
		this.foodCategory = foodCategory;
		this.foodPrice = foodPrice;
		this.name = name;
		this.vendor = vendor;
		this.dateOfPurchase = dateOfPurchase;
		this.coupon_used = coupon_used;
		this.coupon_code = coupon_code;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

