package com.main;

import java.util.List;

public class canteenUtility {
	
public static boolean CustUserNameValid(List<customer> list, String CustUsername) {
		
		boolean userisPresent = false;
		for(customer c :list) {
			if(c.getUserName()== CustUsername) {
				userisPresent = true;
				break;
			}
		}
		return userisPresent;
}

public static boolean CustpasswordValid(List<customer> list, String passWord) {
	
	boolean passisPresent = false;
	for(customer c:list) {
		if(c.getPassword()== passWord) {
			passisPresent = true;
			break;
		}
	}
	return passisPresent;
}








}