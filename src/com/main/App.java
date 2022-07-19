package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.main.service.customerFunctions;
import com.main.service.vendorFunctions;

public class App {
	public static void main(String[] args) {

		DB db = new DB();

		customer c1 = new customer();
		Vendor v1 = new Vendor();
		

		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("\n    Food Court Managment System");
			System.out.println("===================================");
			System.out.println(" Enter 1 for Customer login");
			System.out.println(" Enter 2 for Vendor Login");
			System.out.println(" Enter 3 to View Today's Menu");
			System.out.println(" Enter 4 to Create Customer Login");
			System.out.println(" Enter 5 to Create Vendor Login");
			System.out.println(" Enter 0 to Exit The System");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Closing System...Have a nice day");
				break;
			}
			switch (input) {
			case 1:
				// db.dbConnect();
				System.out.println(" Enter your Username");
				String userName = sc.next();
				boolean validUser = canteenUtility.CustUserNameValid(DB.findcustUsername(), userName);
				if (!validUser) {
					System.out.println(" Invalid Username...Try again");
					break;
				}
				System.out.println(" Enter your Password");
				String passWord = sc.next();
				boolean validPass = canteenUtility.CustpasswordValid(DB.findcustUsername(), passWord);
				if (!validPass) {
					System.out.println("Invalid Password Try Again");
					break;
				}
				customerFunctions.customerMenu();
				// db.dbClose();
				break;
			case 2:
				System.out.println(" Enter your Username");
				String venuserName = sc.next();
				boolean venValidUser = canteenUtility.VenUserNameValid(DB.findVenUsername(), venuserName);
				if (!venValidUser) {
					System.out.println("Invalid Username...Try again");
					break;
				}
				System.out.println(" Enter your password");
				String venpassWord = sc.next();
				boolean venvalidPass = canteenUtility.VenPasswordValid(DB.findVenUsername(), venpassWord);
				if (!venvalidPass) {
					System.out.println("Invalid Password Try Again");
					break;
				}
				vendorFunctions.VendorMenu();

				break;
			case 3:
				System.out.println("\n    Today's Menu");
				System.out.println("======================");
				List<food> list = DB.findFoodName();
				for (food f : list) {
					System.out.println(f);
				
				}
				break;
			case 4:
				System.out.println("Enter Customer name");
				sc.nextLine();
				String custName = sc.nextLine();
				System.out.println("Enter Customer Username");
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
			case 5:
				System.out.println("Enter Vendor's Name");
				sc.nextLine();
				String venName = sc.nextLine();
				System.out.println("Enter Vendor's Username");
				String venUserName = sc.nextLine();
				System.out.println("Enter Vednor's Password");
				String venPassword = sc.nextLine();
				
				v1.setVenName(venName);
				v1.setVenUsername(venUserName);
				v1.setVenPassword(venPassword);
				
				db.addNewVendor(v1);
				System.out.println("New Vendor has been added!");
				
				break;
			default:
				System.out.println("Invalid Selection...Try Again");
			}

		}

	}

}

