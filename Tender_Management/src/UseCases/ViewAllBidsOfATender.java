package UseCases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.Biding;
import Model.Tender;
import Model.User;
import UncheckedException.TenderException;

public class ViewAllBidsOfATender {

	public static void viewAllBidsOfATender(User user) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter a tender id");
		int tender_id = sc.nextInt();

        AdminDao dao = new AdminDaoImpl();
		
		try {
			
			List<Biding> bidings = new ArrayList<>(dao.getAllBidsOfATender(tender_id));
			
			bidings.forEach(b -> System.out.println(b));
			
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
			
		} catch (TenderException e) {
			
			e.printStackTrace();
		}
	}

}
