package com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.main.servce.customerFunctions;
import com.main.servce.vendorFunctions;

public class App {
	public static void main(String[] args) {

		DB db = new DB();

		customer c1 = new customer();
		Vendor v1 = new Vendor();
		

		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Food Court Managment System");
			System.out.println("Press 1 for Customer login");
			System.out.println("Press 2 for Vendor Login");
			System.out.println("Press 3 to show the menu");
			System.out.println("Press 4 to create Customer login");
			System.out.println("Press 5 to Create Vendor login");
			System.out.println("Press 0 to exit the System");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Closing System...Have a nice day");
				break;
			}
			switch (input) {
			case 1:
				// db.dbConnect();
				System.out.println("Enter your Username");
				String userName = sc.next();
				boolean validUser = canteenUtility.CustUserNameValid(DB.findcustUsername(), userName);
				if (!validUser) {
					System.out.println("Invalid Username...Try again");
					break;
				}
				System.out.println("Enter your password");
				String passWord = sc.next();
				boolean validPass = canteenUtility.CustUserNameValid(DB.findcustUsername(), passWord);
				if (!validPass) {
					System.out.println("Invalid Password Try Again");
					break;
				}
				customerFunctions.customerMenu();
				// db.dbClose();
				break;
			case 2:
				System.out.println("Enter your Username");
				String venuserName = sc.next();
				boolean venvalidUser = canteenUtility.CustUserNameValid(DB.findcustUsername(), venuserName);
				if (!venvalidUser) {
					System.out.println("Invalid Username...Try again");
					break;
				}
				System.out.println("Enter your password");
				String venpassWord = sc.next();
				boolean venvalidPass = canteenUtility.CustUserNameValid(DB.findcustUsername(), venpassWord);
				if (!venvalidPass) {
					System.out.println("Invalid Password Try Again");
					break;
				}
				vendorFunctions.VendorMenu();

				break;
			case 3:
				System.out.println("\t\tSelect a food item from the following list");
				// sc.nextLine();
				// String choice = sc.nextLine();
				List<food> list = db.findFoodName();
				for (food f : list) {
					System.out.println(f);

					System.out.println("\nMenu:");
					System.out.println("\n\tItem Description		         ");
					System.out.println("\t===================================");

					File menuFile = new File("Menu.txt");
					try {
						Scanner mf = new Scanner(menuFile);
						while (mf.hasNextLine()) {
							String i = mf.nextLine();
							// System.out.println(i);
							String[] item = i.split(" ");
							// System.out.println(item[1]);
							System.out.println("\t" + item[1] + "\t(" + item[2] + ")");
						}
						mf.close();
					} catch (FileNotFoundException e) {
						// System.out.println("An error has occurred.");
						e.printStackTrace();
					}
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
				System.out.println("Enter Customer name");
				sc.nextLine();
				String venName = sc.nextLine();
				System.out.println("Enter Customer Username");
				String venUserName = sc.nextLine();
				System.out.println("Enter Customer Password");
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
