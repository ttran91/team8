package com.main.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.main.DB;
import com.main.Order;
import com.main.Vendor;
import com.main.canteenUtility;
import com.main.food;

public class vendorFunctions {

	public static void VendorMenu() {

		Order o1 = new Order();
		food f1 = new food();
		
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("\n    Vendor Portal");
			System.out.println("=======================");
			System.out.println(" Enter 1 to View All Customer Orders");
			System.out.println(" Enter 2 to View Pending Orders");
			System.out.println(" Enter 3 to View Confirmed Orders");
			System.out.println(" Enter 4 to View Completed Orders");
			System.out.println(" Enter 5 to View Canceled Orders");
			System.out.println(" Enter 6 to Modify Customer Orders");
			System.out.println(" Enter 7 to Change Menu Items");
			System.out.println(" Enter 8 to Upload New Menu from File");
			System.out.println(" Enter 0 to Log Out");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Logging out...Have a nice day");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("\n    All Orders");
				System.out.println("--------------------------");
				List<Order> allOrderList = DB.findOrder();
				for(Order od: allOrderList) {
					System.out.println(od);
				}
				break;
			case 2:
				System.out.println("\n    Pending Orders");
				System.out.println("--------------------------");
				String penStatus = "Pending";
				o1.setOrderStatus(penStatus);
				List<Order> penList = DB.findOrderStatus(o1);
				for(Order pen: penList) {
					System.out.println(pen);
				}
				break;
			case 3:
				System.out.println("\n    Confirmed Orders");
				System.out.println("--------------------------");
				String conStatus = "Confirmed";
				o1.setOrderStatus(conStatus);
				List<Order> conList = DB.findOrderStatus(o1);
				for(Order con: conList) {
					System.out.println(con);
				}
				break;
			case 4:
				System.out.println("\n    Completed Orders");
				System.out.println("--------------------------");
				String comStatus = "Completed";
				o1.setOrderStatus(comStatus);
				List<Order> comList = DB.findOrderStatus(o1);
				for(Order com: comList) {
					System.out.println(com);
				}
				break;
			case 5:
				System.out.println("\n    Canceled Orders");
				System.out.println("--------------------------");
				String canStatus = "Canceled";
				o1.setOrderStatus(canStatus);
				List<Order> canList = DB.findOrderStatus(o1);
				for(Order can: canList) {
					System.out.println(can);
				}
				break;
			case 6:
				Scanner scan = new Scanner(System.in);
				List<Order> orderList = DB.findOrder();
				boolean orList = orderList.isEmpty();
				while (orList == false) {
				System.out.println("\n    Order Portal");
				System.out.println("==========================");
				System.out.println(" Enter 1 to Accept Customer's Order");
				System.out.println(" Enter 2 to Decline Customer's Order");
				System.out.println(" Enter 3 to Complete Customer's Order");
				System.out.println(" Enter 0 to Exit");
				int orderChoice = scan.nextInt();
				if (orderChoice == 1) {
					System.out.println(" Enter the OrderID you wish to Accept:");
					int acceptId = scan.nextInt();
					String aStat = "Confirmed";
					
					o1.setOrderID(acceptId);
					o1.setOrderStatus(aStat);
					
					DB.changeOrderStatus(o1);
					System.out.println(" The Order has been Confirmed!");
				}
				else if (orderChoice == 2) {
					System.out.println(" Enter the OrderID you wish to Decline");
					int declineId = scan.nextInt();
					String canStat = "Canceled";
					
					o1.setOrderID(declineId);
					o1.setOrderStatus(canStat);
					
					DB.changeOrderStatus(o1);
					System.out.println(" The Order has been Canceled!");
				}	
				else if (orderChoice == 3) {
					System.out.println(" Enter the OrderID you wish to Complete");
					int completeId = scan.nextInt();
					String comStat = "Completed";
					
					o1.setOrderID(completeId);
					o1.setOrderStatus(comStat);
					
					DB.changeOrderStatus(o1);
					System.out.println(" The Order has been Completed!");
				}	
				else if (orderChoice == 0) {
					break;
				}
				else {
					System.out.println(" Invalid Choice.");
				}
				}
				break;
			case 7:
				System.out.println("\n    Today's Menu");
				System.out.println("---------------------------");
				List<food> list = DB.findFoodName();
				for (food f : list) {
					System.out.println(f);
				}
				boolean ans = list.isEmpty();
					while(ans == false) {
					System.out.println("\n    What would you like to do?");
					System.out.println("==================================");
					System.out.println(" Enter 1 to Add a Menu Item");
					System.out.println(" Enter 2 to Delete a Menu Item");
					System.out.println(" Enter 3 to Change Price of a Menu Item");
					System.out.println(" Enter 0 to Exit");
					Scanner ch = new Scanner(System.in);
					int choice = ch.nextInt();
					if (choice == 1) {
						ch.nextLine();
						System.out.println(" Enter Food Name");
						String foodName = ch.nextLine();
						System.out.println(" Enter Food Category");
						String foodCategory = ch.nextLine();
						System.out.println(" Enter Food Price");
						Double foodPrice = ch.nextDouble();
						System.out.println(" Enter Food VendorID");
						int foodVendorID = ch.nextInt();
						System.out.println(" Enter Food Quantity");
						int foodQuantity = ch.nextInt();	
						
						f1.setFoodName(foodName);
						f1.setFoodCat(foodCategory);
						f1.setFoodPrice(foodPrice);
						f1.setVendor_idVendor(foodVendorID);
						f1.setFoodQuantity(foodQuantity);
						
						DB.addNewFood(f1);
						System.out.println(" New Food Item has been Added!");
					}
					else if (choice == 2) {
						ch.nextLine();
						System.out.println(" Enter the Food Name you wish to Remove");
						String delFoodName = ch.nextLine();
						
						f1.setFoodName(delFoodName);
						
						DB.delFood(f1);
						System.out.println(" Food Item has been Removed");
						
					}
					else if (choice == 3) {
						ch.nextLine();
						System.out.println(" Enter the Food ID you wish to change Price");
						int foodID = ch.nextInt();
						boolean valFoodId = canteenUtility.FoodIDValid(DB.findFoodName(), foodID);
						if (!valFoodId) {
							System.out.println(" Invalid Food ID...Try again");
							break;
						}
						System.out.println(" Enter new Price for this item:");
						double newFoodPrice = ch.nextDouble();
						
						f1.setId(foodID);
						f1.setFoodPrice(newFoodPrice);
						
						DB.addNewPrice(f1);
						System.out.println(" Food Price has been Changed!");
					}
					else if( choice == 0) {
						break;
					}
					else {
						System.out.println("Invalid Choice. Please choose again.");
					}
				}
				
				break;
			case 8:
				File menuFile = new File("Menu.txt");
				//System.out.println(menuFile.canRead());
				try {
					Scanner mf = new Scanner(menuFile);
					//System.out.println(mf.hasNextLine());
					while (mf.hasNextLine()) {
						String i = mf.nextLine();
						String[] item = i.split(",");
						System.out.println("-----------------------------------");
						System.out.println("\t" + item[0] + "\t(" + item[2] + ")");
						String menuFoodItem = item[0];
						String menuItemCat= item[1];
						Double menuItemPrice = Double.parseDouble(item[2]);
						int menuItemVendor = Integer.parseInt(item[3]);
						int menuItemQuant = Integer.parseInt(item[4]);
						
						f1.setFoodName(menuFoodItem);
						f1.setFoodCat(menuItemCat);
						f1.setFoodPrice(menuItemPrice);
						f1.setVendor_idVendor(menuItemVendor);
						f1.setFoodQuantity(menuItemQuant);
						
						DB.addNewFood(f1);
						System.out.println("Upload Status: Item Uploaded!");
					}
					mf.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error has occurred.");
					e.printStackTrace();
				}
				break;
			default:
				break;
			}

		}
	}

}













