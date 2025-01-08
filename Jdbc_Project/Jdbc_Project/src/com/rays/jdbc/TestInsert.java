package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class TestInsert {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance", "root", "root");

		System.out.println("insert data please enter ");
		System.out.println("Enter the the unique id");
		int id = sc.nextInt();
		System.out.println("Enter the firstName ");
		String name = sc.next();
		System.out.println("Enter the lastname");
		String lname = sc.next();
		System.out.println("Enter the Salary");
		int sal = sc.nextInt();
		System.out.println("Enter the Address");
		String add = sc.next();
		System.out.println("Enter the age");
		int age = sc.nextInt();
		System.out.println("Enter the deptid");
		int depid = sc.nextInt();

		String q = "insert into employee values(" + id + ", " + "'" + name + "', '" + lname + "', " + sal + ", '" + add
				+ "', " + age + ", " + depid + ")";

		System.out.println(q);

		Statement stmt = con.createStatement();

		stmt.executeUpdate(q);

		System.out.println("Done....");

	}

}
