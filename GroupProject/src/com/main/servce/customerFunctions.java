package com.main.servce;

import java.util.Scanner;

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
				
				
				break;
			case 2:
				break;
			default:
				break;
			}
		
		
		
		
		
		
	}

}
}
