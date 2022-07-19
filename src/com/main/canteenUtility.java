package com.main;

import java.util.List;

public class canteenUtility {
	
public static boolean CustUserNameValid(List<customer> list, String CustUsername) {
		
		boolean userisPresent = false;
		for(customer c :list) {
			if(c.getUserName().equals(CustUsername)) {
				userisPresent = true;
				break;
			}
		}
		return userisPresent;
}

public static boolean CustpasswordValid(List<customer> list, String passWord) {
	
	boolean passisPresent = false;
	for(customer c:list) {
		if(c.getPassword().equals(passWord)) {
			passisPresent = true;
			break;
		}
	}
	return passisPresent;
}

public static boolean CustUserIDValid(List<customer> findcustUsername, int id) {
	boolean IDisPresent = false;
	for(customer c:findcustUsername) {
		if(c.getId() == id) {
			IDisPresent = true;
			break;
		}
	}
	return IDisPresent;
}


public static boolean VenUserNameValid(List<Vendor> findVenUsername, String venUsername) {
	
	boolean venUserIsPresent = false;
	for(Vendor v :findVenUsername) {
		if(v.getVenUsername().equals(venUsername)) {
			venUserIsPresent = true;
			break;
		}
	}
	return venUserIsPresent;
	}

public static boolean VenPasswordValid(List<Vendor> findVenUsername, String venPassword) {
	
	boolean venPassIsPresent = false;
	for(Vendor v :findVenUsername) {
		if(v.getVenPassword().equals(venPassword)) {
			venPassIsPresent = true;
			break;
		}
	}
	return venPassIsPresent;
	}


public static boolean OrderIDValid(List<Order> findOrderDetails, int id) {
	boolean OrderIDisPresent = false;
	for(Order order:findOrderDetails) {
		if(order.getOrderID() == id) {
			OrderIDisPresent = true;
			break;
		}
	}
	return OrderIDisPresent;
	}

public static boolean FoodIDValid(List<food> findFoodID, int id) {
		boolean FoodIDisPresent = false;
		for(food f:findFoodID) {
			if(f.getId() == id) {
				FoodIDisPresent = true;
				break;
			}
		}
		return FoodIDisPresent;
}

















}
