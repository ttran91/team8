package com.main.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.DB;

public class CustomerService {
	DB db = new DB();
	public void updateAddBalance(double balance, int id) {
		DB.dbConnect();
		String sql = "update Customer set CustBalance = ? where idCustomer = ?";
		
		try {
			PreparedStatement prep = DB.con.prepareStatement(sql);
			prep.setDouble(1, balance);
			prep.setInt(2,id);
			
			prep.executeUpdate();//only if changing something in DB
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DB.dbClose();
	}
	public void updateSubBalance(double balance, int id) {
		DB.dbConnect();
		String sql2 = "update Customer set CustBalance = ? where idCustomer = ?";
		
		//updating Database
		try {
			PreparedStatement prep = DB.con.prepareStatement(sql2);
			prep.setDouble(1, balance);
			prep.setInt(2, id);
			//executeQuery
			prep.executeUpdate();//recalling information
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB.dbClose();
		
	}
	public void LowBalance(double withdrawl, double balance) {
		if (balance < withdrawl)
			System.out.println("You don't have enough money to withdrawl");
			return;
		// TODO Auto-generated method stub
		
	}
}