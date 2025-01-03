package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnectionCreate {
	
	public static void main(String[] args) throws Exception {
		
		// step 1 load Driver
		
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jbdc:mysql://localhost:3306/advance";
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", uName, pass);
		
		//  step 3 create statement
		
		Statement stmt = con.createStatement();
		
		String q  = "Select * from employee";
		
		
		
		 System.out.println("Coneection is done.....");
		 
		 ResultSet rs = stmt.executeQuery(q);
		 
		 while(rs.next()) {
			 
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6));
		 }
		
		
	}

}
