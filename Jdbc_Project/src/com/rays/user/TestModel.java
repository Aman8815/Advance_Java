package com.rays.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestModel {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("perform  the  operation");
		System.out.println("1.DataAdditon        2.DataUpdate");
		System.out.println("3.Datadelete         4.DataSearch");
		
		System.out.println("Please enter the number ");
         int num = sc.nextInt();
         
         switch (num) {
		case 1:
			tastAdd();
			break;
		case 2:
			testupdate();
			break;
		case 3:
			testdelete();
			break;
		case 4:
			testSerch();
			break;
		default:
			System.out.println("Invalid number");
			break;
		}
		
		
		// tastAdd();
		// testupdate();
		// testdelete();
		//testSerch();
	}

	private static void testSerch() throws Exception {
		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		List list = model.search();

		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId() + "  " + bean.getFirstName() + "  " + bean.getLastName());
		}
	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();

		model.delete(3);

	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("uday");
		bean.setLastName("dabi");
		bean.setLoginId("uday@gamil.com");
		bean.setPassword("uday123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2022-02-02"));

		bean.setId(1);

		model.update(bean);

	}

	private static void tastAdd() throws Exception {

		UserBean bean = new UserBean();

		UserModel model = new UserModel();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter the firstname");
		

		bean.setFirstName("uday");
		bean.setLastName("dabi");
		bean.setLoginId("uday@gamil.com");
		bean.setPassword("uday123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2022-02-02"));

		model.Add(bean);
	}

}
