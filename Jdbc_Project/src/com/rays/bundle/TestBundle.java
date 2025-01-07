package com.rays.bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class TestBundle {
	public static void main(String[] args) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String uname = rb.getString("username");
		String pwd = rb.getString("password");
		
		Class.forName(driver);
		
		Connection conn =  DriverManager.getConnection(url,uname,pwd);
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	}

}
