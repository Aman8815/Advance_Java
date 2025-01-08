package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
  public static void main(String[] args) throws Exception {
	
	  Connection conn = null;
	  
	  try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				
				
				String uName = "root";
				String pass = "root";
		          
				
				// step 2 Create connection
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
				conn.setAutoCommit(false);
			   Statement stmt =  conn.createStatement();
			    
			   
			int i =   stmt.executeUpdate("update marksheet set physics = 34 where id = 29");
		
			 i =   stmt.executeUpdate("update marksheet set physics = 34 where id = 30");
			
			 i =   stmt.executeUpdate("update marksheet set physics = 34 where id = 31");
			 
			 System.out.println("Data insert success:"+(i+i+i)+"Lines");
			 
			 
			 conn.commit();
	} catch (Exception e) {
		conn.rollback();
		System.out.println(e.getMessage());
	}
}
}
