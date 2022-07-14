package com.main.servce;

import java.util.List;
import java.util.Scanner;

import com.main.DB;
import com.main.customer;

public class customerFunctions {
	
	public static void customerMenu() {
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Customer Menu");
			System.out.println("Press 1 to View Wallet");
			System.out.println("Press 2 to Add to Wallet");
			System.out.println("Press 0 to Log Out");
			
			int input = sc.nextInt();
			if(input ==0) {
				System.out.println("Logging out...Have a nice day");
				break;
			}
			switch(input) {
			case 1:
				System.out.println("Enter your Customer ID");
				int cid = sc.nextInt();
				
				List<customer> list = DB.findcustUsername();
				 for(customer e: list) {
					 System.out.println(e.getCustBalance());
				 }
				
				break;
			case 2:
				break;
			default:
				break;
			}
		
		
		
		
		
		
	}

}
}
