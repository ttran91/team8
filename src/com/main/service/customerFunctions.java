package com.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.main.DB;
import com.main.canteenUtility;
import com.main.customer;
import com.main.food;

public class customerFunctions {
	
	public static void customerMenu() {
		
		customer c1 = new customer();
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n    Customer Portal");
			System.out.println("=============================");
			System.out.println(" Enter 1 to View Account Details");
			System.out.println(" Enter 2 to Add to Wallet");
			System.out.println(" Enter 3 to Withdraw from Balance");
			System.out.println(" Enter 4 View Today's Menu");
			System.out.println(" Enter 5 to Place an Order"); //take idFood and idOrder and add into `order_has_food` table AND create `order` table
			System.out.println(" Enter 6 to View your Orders"); //all orders that this customer has placed in the past
			System.out.println(" Enter 7 to Cancel Orders"); //remove only pending orders, throw invalid if it's already confirmed
			System.out.println(" Enter 0 to Log Out");
			
			int input = sc.nextInt();
			if(input ==0) {
				System.out.println("Logging out...Have a nice day");
				break;
			}
			switch(input) {
			case 1:
				int total;
				//ask user for Customer's ID input
				System.out.println("Confirm Customer's ID");
				int id = sc.nextInt();
				c1.setId(id);
				//Checking if the ID is invalid
				boolean isValid = canteenUtility.CustUserIDValid(DB.findcustUsername(),id);
				if(!isValid) {
					System.out.println("Invalid ID!! Try Again :D");
					break;
				}
				List<customer> clist = DB.showCustBalance(c1);
				for(customer c:clist) {
					System.out.println(clist);
				}
				break;
			case 2:
				
				double deposit;
				
				//Ask user to enter Customer's ID input
				System.out.println("Enter Customer's ID");
				id = sc.nextInt();
				//Ask user to Enter the deposit amount
				System.out.println("How much money would you like to deposit?");
				deposit = sc.nextDouble();
				
				//Checking if the ID is invalid
				boolean isValid2 = canteenUtility.CustUserIDValid(DB.findcustUsername(), id);
				if(!isValid2) {
					System.out.println("Invalid ID!! Try Again :D");
					break;
				}
				
				//commanding database to achieve the value for CustBalance
				DB.dbConnect();
				String sql = "select CustBalance from Customer where idCustomer = ?";
				try {
					PreparedStatement prep = DB.con.prepareStatement(sql);
					prep.setInt(1, id);
					
					
					ResultSet result = prep.executeQuery();
					result.next(); //points to the first value of table
					
					//Assign the result value to balance
					double balance = result.getDouble("CustBalance");
					balance = balance + deposit;
					DB.dbClose();
					//Call CustomerService object to use updateBalance method
					CustomerService CustService = new CustomerService();
					//This will update the CustBalance
					CustService.updateAddBalance(balance,id);
				}catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 3:
				
				CustomerService withDrawlWarning = new CustomerService();
				double withdrawl;
				//Ask user to enter Customer's ID input
				System.out.println("Enter Customer's ID");
				id = sc.nextInt();
				
			
				//Checking if the ID is invalid
				boolean isValid3 = canteenUtility.CustUserIDValid(DB.findcustUsername(), id);
				if(!isValid3) {
					System.out.println("Invalid ID!! Try Again :D");
					break;
				}
				
				System.out.println("How much money will you deposit?");
				withdrawl = sc.nextDouble();
				
				
				//commanding database to achieve the value for CustBalance
				DB.dbConnect();
				String sql2 = "select CustBalance from Customer where idCustomer = ?";
				try {
					PreparedStatement prep = DB.con.prepareStatement(sql2);
					prep.setInt(1, id);
					
					ResultSet result = prep.executeQuery();
					result.next();
					
					//Get the information and assign that value to balance
					double balance = result.getDouble("CustBalance");
					
					withDrawlWarning.LowBalance(withdrawl, balance);
					
					//********************************************************* HOW TO STOP THE CODE HERE??******************
					// BREAK; WILL NOT WORK!!!
					balance = balance - withdrawl;
					
					//Call CustomerService object to use updateBalance method
					DB.dbClose();
					CustomerService CustService = new CustomerService();
					//This will update the CustBalance
					if( balance >= 0) {
						CustService.updateSubBalance(balance,id);
					}
					
				}
				catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 4:
				System.out.println("\n    Today's Menu");
				System.out.println("======================");
				List<food> list = DB.findFoodName();
				for (food f : list) {
					System.out.println(f);
				}
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				break;
			}
		
		
		
		
		
		
		}

	}
}
