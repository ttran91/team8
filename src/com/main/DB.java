package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.main.service.CustomerService;

public class DB {
	public static Connection con;
	
	public static void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodCourtAdministration"
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
	
	
	//===================================CUSTOMER FUNCTIONS===========================================
	
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
		
	}
	
	//=====================================FOOD FUNCTIONS==========================================

	public static List<food> findFoodName() {
		dbConnect();
		String sql="Select * from Food";
		List<food> list = new ArrayList<>();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new food(rst.getInt("idFood"), rst.getString("FoodName"), rst.getString("FoodCategory"), rst.getDouble("FoodPrice"),rst.getInt("Vendor_idVendor"),rst.getInt("FoodQuantity")));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	
	public static void addNewFood(food f1) {
		dbConnect();
		String sql = "insert into food(FoodName,FoodCategory,FoodPrice,Vendor_idVendor, FoodQuantity) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, f1.getFoodName());
			pstmt.setString(2, f1.getFoodCat());
			pstmt.setDouble(3, f1.getFoodPrice());
			pstmt.setInt(4, f1.getVendor_idVendor());
			pstmt.setInt(5, f1.getFoodQuantity());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
		
	}
	
	public static void delFood(food f1) {
		dbConnect();
		String sql = "DELETE FROM food WHERE FoodName=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, f1.getFoodName());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}
	
	public static void addNewPrice(food f1) {
		dbConnect();
		String sql = "UPDATE food SET FoodPrice =? WHERE idFood =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, f1.getFoodPrice());
			pstmt.setInt(2, f1.getId());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}
	
//	public static double Food(food f1) {
//		dbConnect();
//        double foodBal = 0;
//        String sql = "select FoodPrice from Food where idFood = ?";
//        try {
//        	PreparedStatement prep = con.prepareStatement(sql);
//        	prep.setInt(1, f1.getId());
//
//        //receive the data from the food table
//        ResultSet result = prep.executeQuery();
//
//        //got the food price!!
//        foodBal = result.getDouble("FoodPrice");
//        }
//        catch (SQLException e) {
//        e.printStackTrace();
//        }
//        dbClose();
//        return foodBal;
//	}

	
	//=====================================VENDOR FUNCTIONS=====================================
	
	public void addNewVendor(Vendor v1) {
		dbConnect();
		String sql = "insert into vendor(VenName,VenUsername,VenPassword) values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v1.getVenName());
			pstmt.setString(2, v1.getVenUsername());
			pstmt.setString(3, v1.getVenPassword());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}
	
	
	public static List<Vendor> findVenUsername(){
		dbConnect();
		String sql="Select * from Vendor";
		List<Vendor> list = new ArrayList<>();
		try {
			
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				
				while(rst.next()) {
					list.add(new Vendor(rst.getInt("idVendor"), rst.getString("VenName"), rst.getString("VenUsername"), rst.getString("VenPassword")));
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	

	
//===========================ORDER FUNCTIONS============================================
	
	public static List<Order> findOrder() {
		dbConnect();
		String sql="Select * from `Order`";
		List<Order> list = new ArrayList<>();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Order(rst.getInt("idOrder"), rst.getString("OrderStatus"), rst.getDouble("OrderCost"), rst.getInt("idCustomer")));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	public static List<Order> findOrderID(Order Order) {
		dbConnect();
		String sql = "select * from `order` where idOrder = ?";
		List<Order> list = new ArrayList<>();
		try {
			
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Order.getOrderID());
				//pstmt.executeUpdate();
				ResultSet rst = pstmt.executeQuery();
				
				while(rst.next()) {
					list.add(new Order(rst.getInt("idOrder"), rst.getString("OrderStatus"), rst.getDouble("OrderCost"), rst.getInt("idCustomer")));
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	public static List<Order> findOrderStatus(Order Order) {
		dbConnect();
		String sql = "select * from `order` where OrderStatus = ?";
		List<Order> list = new ArrayList<>();
		try {
			
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, Order.getOrderStatus());
				//pstmt.executeUpdate();
				ResultSet rst = pstmt.executeQuery();
				
				while(rst.next()) {
					list.add(new Order(rst.getInt("idOrder"), rst.getString("OrderStatus"), rst.getDouble("OrderCost"), rst.getInt("idCustomer")));
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}


	public static void changeOrderStatus(Order o1) {
		dbConnect();
		String sql = "UPDATE `order` SET OrderStatus =? WHERE idOrder =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, o1.getOrderStatus());
			pstmt.setInt(2, o1.getOrderID());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		
	}





	


	



	
}

