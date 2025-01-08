package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class TestMetadata{
	public static void main(String[] args) throws Exception {

		 
		  
				 Class.forName("com.mysql.cj.jdbc.Driver");
					
					
					String uName = "root";
					String pass = "root";
			          
					
					// step 2 Create connection
					 Connection conn =conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
			
				   PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");
				   
				   ResultSet rs = pstmt.executeQuery();
				   
				  ResultSetMetaData rsmt =rs.getMetaData();
				  
				  int i = rsmt.getColumnCount();
				  System.out.println(i);
				  
				  for(int j =1;j<=i;j++) {
					  System.out.println("Total colum is =>"+rsmt.getColumnName(j));
				  }
		
	}

}
