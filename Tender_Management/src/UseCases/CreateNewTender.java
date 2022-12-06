package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.User;
import UncheckedException.AdminException;
import UncheckedException.TenderException;

public class CreateNewTender {

	public static void createNewTender(User user) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the details to create new tender"+"\n");
		
		
		System.out.println("Enter tender id of the tender");
		int id = sc.nextInt();
		
		System.out.println("Enter start date of the Tender");
		String start_date = sc.next();
		
		
	
		System.out.println("Enter last date of the Tender");
		String last_date = sc.next();
		
		
		System.out.println("Enter name of the tender");
		String tender_name = sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		try {
			String result = dao.createNewTender(id, start_date, last_date,  tender_name);
			
			System.out.println(result);
			
			System.out.println("\n");
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
			
		} catch (TenderException e) {
			
			System.out.println("Something went wrong, please try again");
		}

	}

}
