package com.springboot.backend.enums;

public enum CouponCode {
	DIS50AUGUST(50), DIS40AUGUST(40), DIS30AUGUST(30), DIS20AUGUST(20), DIS10AUGUST(10);
	
	private double discount;
	
	CouponCode(double discount){
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
}
