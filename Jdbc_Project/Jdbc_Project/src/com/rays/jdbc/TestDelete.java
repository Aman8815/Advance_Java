package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TestDelete {
	
	public static void main(String[] args)  throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance","root","root");
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Enter the id for delete");
		int id = sc.nextInt();
		String q = "delete from employee where  id = "+id;
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate(q);
		
		
		System.out.println("Data delete Done...!");
		
	}

}
