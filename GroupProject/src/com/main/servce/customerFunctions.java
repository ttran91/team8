package com.main.servce;

import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.main.DB;
import com.main.canteenUtility;
import com.main.customer;

public class customerFunctions {
	
	public static void customerMenu() {
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Customer Menu");
			System.out.println("Press 1 to View Account details");
			//System.out.println("Press 2 to Add to Wallet");
			System.out.println("Press 0 to Log Out");
			
			int input = sc.nextInt();
			if(input ==0) {
				System.out.println("Logging out...Have a nice day");
				break;
			}
			switch(input) {
			case 1:
				int total;
				customer c1 = new customer();
				//ask user for Customer's ID input
				System.out.println("Enter Customer's ID");
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
				//Fetching Food price with the Food ID input
				//or Statement statement = connection.createStatement(); 
				/*Statement statement = DB.dbConnect();
				String sql = "select Custbalance from Customer where idCustomer = ?" +id;
				
				ResultSet result = statement.executeQuery(sql);
				
				int CusB = result.getCustBalance("CustBalance");*/
				
				
				 
				
				break;
			case 2:
				break;
			default:
				break;
			}
		
		
		
		
		
		
	}

}
}
