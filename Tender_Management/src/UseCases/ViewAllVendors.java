package UseCases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.User;
import UncheckedException.AdminException;

public class ViewAllVendors {

	public static void viewAllVendors(User user)  {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			
			List<User> vendors = new ArrayList<>(dao.viewAllVendors());
			
			vendors.forEach(v -> System.out.println(v));
			
			System.out.println("\n"+"\n");
			System.out.println("1. Back");
			System.out.println("2. LogOut/Exit");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			try {
				switch(choice) {
			     case 1 :{
			    	 Admin.getStarted(user);
			     }
			     break;
			     case 2 :{
			    	 System.out.println("Thank you");
			    	 System.exit(0);
			     }
			     break;
			     default:{
			    	 System.out.println( "Please choose a number from below options");
			    	 Admin.getStarted(user);
			     }
			}
			}catch(InputMismatchException e) {
				System.out.println( "Input type should be a number");
				Admin.getStarted(user);
			}
			
		} catch (AdminException e) {
			
			e.printStackTrace();
		}

	}

}
