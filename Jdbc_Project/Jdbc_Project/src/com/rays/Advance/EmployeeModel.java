package com.rays.Advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.util.JDBCDataSource;

public class EmployeeModel {
	
	public int nextpk() throws SQLException, Exception {
		int pk =0;
		
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select max(id) from employee");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			pk = pk+rs.getInt(1);
			System.out.println(pk+1);
		}
		
		return pk+1;
	}
	
	public void add(EmployeeBean bean) throws SQLException, Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
		
		pstmt.setInt(1,nextpk());
		pstmt.setString(2,bean.getFname());
		pstmt.setString(3,bean.getLname());
		pstmt.setInt(4,bean.getSalary());
		pstmt.setString(5,bean.getAddress());
		pstmt.setInt(6,bean.getAge());
		pstmt.setInt(7,bean.getDeptid());
		pstmt.executeUpdate();
		
		System.out.println("data added successfully");
		
		
		
	}
	
	public void update(EmployeeBean bean) throws SQLException, Exception {
		
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("update employee set firstname = ?,lastname = ?,salary = ? ,address = ? ,age =?,depid =? where id =?");
		
		pstmt.setString(1,bean.getFname());
		pstmt.setString(2,bean.getLname());
		pstmt.setInt(3,bean.getSalary());
		pstmt.setString(4,bean.getAddress());
		pstmt.setInt(5,bean.getAge());
		pstmt.setInt(6,bean.getDeptid());
		pstmt.setInt(7,bean.getId());
		pstmt.executeUpdate();
		
		System.out.println("Data update succesfully");
		
		
	}
	
	public void delete(int id) throws SQLException, Exception {
		Connection con =  JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("delete from employee where id =?");
		  pstmt.setInt(1,id);
		  pstmt.executeUpdate();
		  
		  System.out.println("Delete data succesfully");
		
	}
	
	public List search() throws SQLException, Exception {
		List list = new ArrayList();
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from employee");
		ResultSet rs = pstmt.executeQuery();
		EmployeeBean bean = null;
		
		while(rs.next()) {
			bean = new EmployeeBean();
			
			bean.setId(rs.getInt(1));
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setSalary(rs.getInt(4));
			bean.setAddress(rs.getString(5));
			bean.setAge(rs.getInt(6));
			bean.setDeptid(rs.getInt(7));
			list.add(bean);
		}
		return list;

	}

}
