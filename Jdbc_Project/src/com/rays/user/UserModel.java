package com.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserModel {
	
	public int nextpk() throws Exception {
		int pk=0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jbdc:mysql://localhost:3306/project";
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", uName, pass);
		
		//  step 3 create statement
		  PreparedStatement  pstmt = con.prepareStatement("select max(id) from st_user");
		  
		   ResultSet rs  = pstmt.executeQuery();
		   while(rs.next()) {
			    pk =rs.getInt(1);
		   }
	
		return pk+1;
	}
	
	public  void Add(UserBean bean) throws Exception {
		
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jbdc:mysql://localhost:3306/project";
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", uName, pass);
		
		//  step 3 create statement
		  PreparedStatement  pstmt = con.prepareStatement("insert into  st_user values(?,?,?,?,?,?,?)");
		  
		    pstmt.setInt(1,nextpk() );
		    pstmt.setString(2,bean.getFirstName());
		    pstmt.setString(3,bean.getLastName());
		    pstmt.setString(4,bean.getLoginId());
		    pstmt.setString(5,bean.getPassword());
		    pstmt.setString(6,bean.getAddress());
		    pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
		    
		    pstmt.executeUpdate();
		    
		    System.out.println("data addedd sucess");
		
	}
	
	public void update(UserBean bean) throws Exception {
		
		  Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String uName = "root";
			String pass = "root";
	          
			
			// step 2 Create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", uName, pass);
			
			//  step 3 create statement
			  PreparedStatement  pstmt = con.prepareStatement(
		"update st_user set firstname = ?, lastname = ?,loginid = ?, pasword = ?,address = ?,dob = ?  where id = ?");
			  
			    
			    pstmt.setString(1,bean.getFirstName());
			    pstmt.setString(2,bean.getLastName());
			    pstmt.setString(3,bean.getLoginId());
			    pstmt.setString(4,bean.getPassword());
			    pstmt.setString(5,bean.getAddress());
			    pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
			    pstmt.setInt(7,bean.getId() );
			    
			    pstmt.executeUpdate();
			    
			    System.out.println("Date Uppdate sucess");
		
	}
	
	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", uName, pass);
		
		  PreparedStatement  pstmt = con.prepareStatement("delete from st_user where id = ?");
		  pstmt.setInt(1, id);
		  
		  pstmt.executeUpdate();
		  
		  System.out.println("Delete sucess data");
		
	}
	
	public List search() throws Exception {
		List list = new ArrayList();
Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String uName = "root";
		String pass = "root";
          
		
		// step 2 Create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", uName, pass);
		
		  PreparedStatement  pstmt = con.prepareStatement("select * from st_user");
		    ResultSet rs =  pstmt.executeQuery();
		    
		    UserBean bean = null;
		    
		    while(rs.next()) {
		    	bean = new UserBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setFirstName(rs.getString(2));
		    	bean.setLastName(rs.getString(3));
		    	list.add(bean);
		    }
		    
		
		return list;
		
		
	}
	
	
	
	
	
	
	
	

}
