package UseCases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.Biding;
import Model.User;
import UncheckedException.TenderException;

public class AssignTenderToVendor {
	
	public static void assignTenderToVendor(User user) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter tender id");
		
		int tender_id = sc.nextInt();

        AdminDao dao = new AdminDaoImpl();
		

		try {
			
			List<Biding> bidings = new ArrayList<>(dao.getAllBidsOfATender(tender_id));
			
			bidings.forEach(b->System.out.println(b));
			
			System.out.println("Please enter biding id from the above list");
			
			int biding_id = sc.nextInt();
			
			String result = dao.assignedTender(biding_id);
			
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
			
			e.printStackTrace();
		}
		
	}

}
