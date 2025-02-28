package com.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String uname = rb.getString("username");
	String pwd = rb.getString("password");

	public int nextpk() throws Exception {
		int pk = 0;

		Class.forName(driver);

		// step 2 Create connection
		Connection con = DriverManager.getConnection(url, uname, pwd);

		// step 3 create statement
		PreparedStatement pstmt = con.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
	}

	public void Add(UserBean bean) throws Exception {

		Class.forName(driver);

		// step 2 Create connection
		Connection con = DriverManager.getConnection(url, uname, pwd);
		UserBean Exist = FindByLoginId(bean.getLoginId());

		if (Exist != null) {
			System.err.println("LoginId Al Ready Exist");
		} else {
			// step 3 create statement
			PreparedStatement pstmt = con.prepareStatement("insert into  st_user values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, nextpk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLoginId());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getAddress());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			pstmt.executeUpdate();

			System.out.println("data addedd sucess");
		}
	}

	public void update(UserBean bean) throws Exception {

		Class.forName(driver);

		// step 2 Create connection
		Connection con = DriverManager.getConnection(url, uname, pwd);

		// step 3 create statement
		PreparedStatement pstmt = con.prepareStatement(
				"update st_user set firstname = ?, lastname = ?,loginid = ?, pasword = ?,address = ?,dob = ?  where id = ?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLoginId());
		pstmt.setString(4, bean.getPassword());
		pstmt.setString(5, bean.getAddress());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(7, bean.getId());

		pstmt.executeUpdate();

		System.out.println("Date Uppdate sucess");

	}

	public void delete(int id) throws Exception {
		Class.forName(driver);

		// step 2 Create connection
		Connection con = DriverManager.getConnection(url, uname, pwd);

		PreparedStatement pstmt = con.prepareStatement("delete from st_user where id = ?");
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		System.out.println("Delete sucess data");

	}

	public List search(UserBean bean) throws Exception {
		List list = new ArrayList();
		Class.forName(driver);

		// step 2 Create connection
		Connection con = DriverManager.getConnection(url, uname, pwd);

		StringBuffer stf = new StringBuffer("select * from st_user where 1 = 1 ");

		if (bean != null) {
			if(bean.getId()>0) {
				stf.append("and id = "+bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				stf.append("and firstname like '" + bean.getFirstName() + "%'");
			}
		}

		if (bean != null) {
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				stf.append("and lastname like '" + bean.getLastName() + "%'");
			}
		}

		if (bean != null) {
			if (bean.getLoginId() != null && bean.getLoginId().length() > 0) {
				stf.append("and loginid like '" + bean.getLoginId() + "%'");
			}
		}
		if (bean != null) {
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				stf.append("and pasword like '" + bean.getPassword() + "%'");
			}
		}
		if (bean != null) {
			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				stf.append("and address like '" + bean.getAddress() + "%'");
			}
		}

		if (bean != null) {
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				java.sql.Date d = new java.sql.Date(bean.getDob().getTime());
				stf.append("and dob like '" + d + "%'");
				System.out.println(stf.toString());
			}
		}

		PreparedStatement pstmt = con.prepareStatement(stf.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setDob(rs.getDate(7));
			list.add(bean);
		}

		return list;

	}

	public UserBean FindByLoginId(String LoginId) throws Exception {
		Class.forName(driver);

		// step 2 Create connection
		Connection con = DriverManager.getConnection(url, uname, pwd);

		PreparedStatement pstmt = con.prepareStatement("select * from st_user where loginid = ?");
		pstmt.setString(1, LoginId);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
		}

		return bean;

	}

}
