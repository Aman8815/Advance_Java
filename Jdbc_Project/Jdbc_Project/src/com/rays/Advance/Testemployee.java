package com.rays.Advance;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Testemployee {
	
	public static void main(String[] args) throws SQLException, Exception {
		
		//TestAdd();
		//Testsearch();
		//testdelete();
		testupdate();
	
	}

	private static void testupdate() throws SQLException, Exception {
		EmployeeModel model = new EmployeeModel();
		 EmployeeBean bean  = new EmployeeBean();
		 bean.setFname("aman");
			bean.setLname("yashona");
			bean.setSalary(12000);
			bean.setAddress("indore");
			bean.setAge(22);
			bean.setDeptid(3);
			bean.setId(1);
			
			model.update(bean);
	}

	private static void testdelete() throws SQLException, Exception {
		 EmployeeModel model = new EmployeeModel();
		 EmployeeBean bean  = new EmployeeBean();
		 model.delete(30);
	}

	private static void Testsearch() throws SQLException, Exception {
       EmployeeModel model = new EmployeeModel();
		
		EmployeeBean bean  = new EmployeeBean();
		List list = model.search();
		
	 Iterator it = 	list.iterator();
	 while(it.hasNext()) {
		 bean = (EmployeeBean)it.next();
		 System.out.println(bean.getId()+" "+bean.getFname()+" "+bean.getLname()+" "+bean.getSalary()
		 
				 +" "+bean.getAddress()+"  "+bean.getAge()+" "+bean.getDeptid());
	 }
		
	}

	private static void TestAdd() throws SQLException, Exception {
       
		EmployeeModel model = new EmployeeModel();
		
		EmployeeBean bean  = new EmployeeBean();
		
		bean.setFname("aman");
		bean.setLname("yashona");
		bean.setSalary(12000);
		bean.setAddress("indore");
		bean.setAge(22);
		bean.setDeptid(3);
		
		
		model.add(bean);
		
	}
	
	
	


}
