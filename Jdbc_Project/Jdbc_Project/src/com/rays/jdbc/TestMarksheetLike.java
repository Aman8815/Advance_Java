package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestMarksheetLike {
	
	public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", uName, pass);
		
	   PreparedStatement pstmt =  con.prepareStatement("select * from marksheet where name like '%a'");
	      ResultSet rs  =  pstmt.executeQuery();
	      
	      while(rs.next()) {
	    	  
	    	  int total = rs.getInt(4)+rs.getInt(5)+rs.getInt(6);
	    	  double per = (rs.getInt(4)+rs.getInt(5)+rs.getInt(6))/3;
	    	  
	    	  System.out.println(rs.getInt(1)+
	    	  " "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+total+" "+per);
	      }
	}

}
