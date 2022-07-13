package com.main;

import java.util.List;
import java.util.Scanner;

import com.main.servce.customerFunctions;

public class App {
	public static void main(String[] args) {
		
		DB db = new DB();
		
		customer c1 = new customer();
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Food Court Managment System");
			System.out.println("Press 1 for Customer login");
			System.out.println("Press 2 for Vendor Login");
			System.out.println("Press 3 to show the menu");
			System.out.println("Press 4 to create Customer login");
			System.out.println("Press 0 to exit the System");
			
			int input = sc.nextInt();
			if(input ==0) {
				System.out.println("Closing System...Have a nice day");
				break;
			}
			switch(input) {
			case 1:
				//db.dbConnect();
				System.out.println("Enter your Username");
				sc.nextLine();
				String userName=sc.nextLine();
				boolean validUser = canteenUtility.CustUserNameValid(db.findcustUsername(), userName);
				if(validUser) {
					System.out.println("Invalid Username...Try again");
					break;
				}
				System.out.println("Enter your password");
				String passWord = sc.nextLine();
				boolean validPass = canteenUtility.CustUserNameValid(db.findcustUsername(), passWord);
				if(validPass) {
					System.out.println("Invalid Password Try Again");
					break;
				}
				customerFunctions.customerMenu();
				
				
				
				
				
				
				
				//db.dbClose();
				break;
			case 2:
				 List<customer> list = db.findcustUsername();
				 for(customer e: list) {
					 System.out.println(e);
				 }
				break;
			case 3:
				break;
			case 4:
				System.out.println("Enter Customer name");
				sc.nextLine();
				String custName = sc.nextLine();
				System.out.println("Enter Customer name");
				String custUserName = sc.nextLine();
				System.out.println("Enter Customer Password");
				String custPassword = sc.nextLine();
				System.out.println("Enter Customer initial balance");
				double custBalance = sc.nextDouble();
				
				c1.setCustName(custName);
				c1.setUserName(custUserName);
				c1.setPassword(custPassword);
				c1.setCustBalance(custBalance);
				
				db.addNewCustomer(c1);
				System.out.println("New customer has been Added!");
				break;
			}
			
			
			
			
		}
		
		
		
		
		
	}

}
