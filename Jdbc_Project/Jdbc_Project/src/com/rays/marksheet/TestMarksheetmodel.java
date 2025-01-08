package com.rays.marksheet;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TestMarksheetmodel {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		System.out.println("1.Addoperation           2.updateoperaton");
		System.out.println("3. deleteoperation       4.searchopration");
		System.out.println("5.maridemark.Operation   6.passfailoperation");
		System.out.println("Please Enter the number");
		int num = sc.nextInt();
		
		switch (num) {
		case 1:
			testadd();
			break;
		case 2:
			testupdate();
            break;
		case 3:
			testdelete();
            break;
		case 4:
			testserch();
			break;
		case 5:
			testmaridemarksheet();
			break;
		case 6:
			testpassfail();
			break;
		case 7:
			testchoiceoperation();
			break;
		default:
			System.err.println("Invalid number");
			break;
		}
		//testadd();
	    //testupdate();
		//testdelete();
		//testserch();
		//testmaridemarksheet();
	}

	private static void testchoiceoperation() throws Exception {
		 MarksheetBean bean = new MarksheetBean();
			
	     MarksheetModel model = new MarksheetModel(); 
	     //bean.setId(2);
	     //bean.setName("abhijeet");
	    // bean.setPhysics(34);
	      List list =  model.choice(bean);
	       Iterator it =  list.iterator();
	       
	       while(it.hasNext()) {
	    	   bean = (MarksheetBean)it.next();
	    	   int total = bean.getPhysics()+bean.getChemestry()+bean.getMaths();
	    	   
	    	   double per = (bean.getPhysics()+bean.getChemestry()+bean.getMaths())/3;
	    	   if(bean.getPhysics()>=33 && bean.getChemestry()>=33 && bean.getMaths()>=33) {
	    	   System.out.println(bean.getId()+" "+bean.getRollno()+"  "+bean.getName()+" "+bean.getPhysics()+" "+bean.getChemestry()+" "+bean.getMaths()+" "+total+" "+per+" "+"Pass");
	    	   }
	    	   else {
	    		System.out.println(bean.getId()+" "+bean.getRollno()+"  "+bean.getName()+" "+bean.getPhysics()+" "+bean.getChemestry()+" "+bean.getMaths()+" "+total+" "+per+" "+"Fail");
	    	   
	    	   }
	       }
		
	}

	private static void testpassfail() throws Exception {
		 MarksheetBean bean = new MarksheetBean();
			
	     MarksheetModel model = new MarksheetModel();
	     
	      List list =  model.passfail();
	       Iterator it =  list.iterator();
	       
	       while(it.hasNext()) {
	    	   bean = (MarksheetBean)it.next();
	    	   int total = bean.getPhysics()+bean.getChemestry()+bean.getMaths();
	    	   
	    	   double per = (bean.getPhysics()+bean.getChemestry()+bean.getMaths())/3;
	    	   if(bean.getPhysics()>=33 && bean.getChemestry()>=33 && bean.getMaths()>=33) {
	    	   System.out.println(bean.getId()+" "+bean.getRollno()+"  "+bean.getName()+" "+bean.getPhysics()+" "+bean.getChemestry()+" "+bean.getMaths()+" "+total+" "+per+" "+"Pass");
	    	   }
	    	   else {
	    		System.out.println(bean.getId()+" "+bean.getRollno()+"  "+bean.getName()+" "+bean.getPhysics()+" "+bean.getChemestry()+" "+bean.getMaths()+" "+total+" "+per+" "+"Fail");
	    	   
	    	   }
	       }
		
	}

	private static void testmaridemarksheet() throws Exception {
		 MarksheetBean bean = new MarksheetBean();
			
	     MarksheetModel model = new MarksheetModel();
	     
	      List list =  model.maridemarksheet();
	       Iterator it =  list.iterator();
	       
	       while(it.hasNext()) {
	    	   bean = (MarksheetBean)it.next();
	    	   int total = bean.getPhysics()+bean.getChemestry()+bean.getMaths();
	    	   
	    	   double per = (bean.getPhysics()+bean.getChemestry()+bean.getMaths())/3;
	    	   System.out.println(bean.getId()+" "+bean.getRollno()+"  "+bean.getName()+" "+bean.getPhysics()+" "+bean.getChemestry()+" "+bean.getMaths()+" "+total+" "+per);
	    	   
	       }
		
	}

	private static void testserch() throws Exception {
		 MarksheetBean bean = new MarksheetBean();
			
	     MarksheetModel model = new MarksheetModel();
	     
	      List list =  model.search();
	       Iterator it =  list.iterator();
	       
	       while(it.hasNext()) {
	    	   bean = (MarksheetBean)it.next();
	    	   System.out.println(bean.getId()+" "+bean.getRollno()+"  "+bean.getName()+" "+bean.getPhysics()+" "+bean.getChemestry()+" "+bean.getMaths());
	    	   
	       }
		
	}

	private static void testdelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		
		model.delete(22);
		
		
	}

	private static void testupdate() throws Exception {
        MarksheetBean bean = new MarksheetBean();
		
		MarksheetModel model = new MarksheetModel();
		
		bean.setRollno(1022);
		bean.setName("aman");
		bean.setPhysics(45);
		bean.setChemestry(35);
		bean.setMaths(13);
		bean.setId(22);
		model.update(bean);
		
	}

	private static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		MarksheetModel model = new MarksheetModel();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name");
		String name = sc.next();
		System.out.println("Enter the physics number");
		int ph = sc.nextInt();
		System.out.println("Enter the chemestry number");
		int ch = sc.nextInt();
		System.out.println("Enter the maths number");
		int ma = sc.nextInt();
	
		bean.setName(name);
		bean.setPhysics(ph);
		bean.setChemestry(ch);
		bean.setMaths(ma);
		
		model.add(bean);
		
		
	}

}
