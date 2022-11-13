package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.User;
import UncheckedException.AdminException;

public class RegisterNewAdmin {

	public static void registerNewAdmin(User user) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the details below");
		System.out.println("Enter email id of the Admin");
		String email = sc.next();
		
		System.out.println("Enter password id of the Admin");
		String password = sc.next();
		
		System.out.println("Enter username id of the Admin");
		String username = sc.next();
		
		System.out.println("Enter name of the Admin");
		String name = sc.next();
		
		
		boolean role = true;
		
		System.out.println("Enter phone number of the Admin");
		String phone = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		try {
			User newuser = dao.registerNewVendor(email, password, username, name, role, phone);
			
			System.out.println("Admin's username is "+ newuser.getUsername() + "and password is "+newuser.getPassword());
			
			System.out.println("\n"+"\n");
			System.out.println("1. Back");
			System.out.println("2. LogOut/Exit");
			
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
			// TODO Auto-generated catch block
			System.out.println("Something went wrong, please try again");
		}

	}

}
