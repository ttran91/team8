package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {
	static Connection con;
	
	public static void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodCourtManagement"
					,"root","Password123");
			//System.out.println("Connection Established..");
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	
	
	public static void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addNewCustomer(customer customer) {
		
		dbConnect();
		String sql = "insert into customer(CustName,CustUsername,CustPassword,CustBalance) values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getCustName());
			pstmt.setString(2, customer.getUserName());
			pstmt.setString(3, customer.getPassword());;
			pstmt.setDouble(4, customer.getCustBalance());;
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}

	

	
	public static List<customer> findcustUsername(){
		dbConnect();
		String sql="Select * from Customer";
		List<customer> list = new ArrayList<>();
		try {
			
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				
				while(rst.next()) {
					list.add(new customer(rst.getInt("idCustomer"), rst.getString("CustName"), rst.getString("CustUsername"), rst.getString("CustPassword"), rst.getDouble("CustBalance")));
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}


	public List<food> findFoodName() {
		dbConnect();
		String sql="Select * from Food";
		List<food> list = new ArrayList<>();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new food(rst.getInt("idFood"), rst.getString("FoodName"), rst.getString("FoodCategory"), rst.getDouble("FoodPrice"),rst.getInt("Vendor_idVendor")));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
		
		
		
		
		
		
		
	}


	public void addNewVendor(Vendor v1) {
		dbConnect();
		String sql = "insert into vendor(VenName,VenUsername,VenPassword) values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v1.getVenName());
			pstmt.setString(2, v1.getVenUsername());
			pstmt.setString(3, v1.getVenPassword());
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}
	
	public static List<customer> showCustBalance(customer customer) {
		dbConnect();
		String sql = "select * from Customer where idCustomer = ?";
		List<customer> list = new ArrayList<>();
		try {
			
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, customer.getId());
				//pstmt.executeUpdate();
				ResultSet rst = pstmt.executeQuery();
				
				while(rst.next()) {
					list.add(new customer(rst.getInt("idCustomer"), rst.getString("CustName"), rst.getString("CustUserName"), rst.getString("CustPassword"), rst.getDouble("CustBalance")));
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
		
		/*ResultSet result = statement.executeQuery(sql);
		
		int CusB = result.getCustBalance("CustBalance");*/
	}
	
	
}

