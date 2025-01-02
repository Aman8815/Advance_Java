package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TestUpdate {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance","root","root");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the coluum for  update");
		 String name = sc.next();
		 
		 System.out.println("Enter the update name");
		 String uname = sc.next();
		 
		 System.out.println("Enter the update id");
		 int id = sc.nextInt();
		
		String q = "update employee set "+name+" = '"+uname+"' where id="+id;
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(q);
		
		System.out.println("Update Done....");
	}

}
