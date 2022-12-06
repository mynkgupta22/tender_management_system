package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.VendorDao;
import Dao.VendorDaoImpl;
import Model.User;
import UncheckedException.TenderException;

public class BidStatus {
	
	public static void bidStatus(User user) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter tender id to see the status");
		
		int tender_id = sc.nextInt();
		String email = user.getEmail();
		
		VendorDao dao = new VendorDaoImpl();
		
		try {
			String result = dao.getStatus(tender_id,email);
			
			System.out.println(result);
			
			System.out.println("\n"+"\n");
			System.out.println("1. Back");
			System.out.println("2. LogOut/Exit");
			
			int choice = sc.nextInt();
			try {
				switch(choice) {
			     case 1 :{
			    	 Vendor.getStarted(user);
			     }
			     break;
			     case 2 :{
			    	 System.out.println("Thank you");
			    	 System.exit(0);
			     }
			     break;
			     default:{
			    	 System.out.println( "Please choose a number from below options...");
			    	 Vendor.getStarted(user);
			     }
			}
			}catch(InputMismatchException e) {
				System.out.println( "Input type should be a number");
				Vendor.getStarted(user);
			}
			
		}catch(TenderException e) {
			e.printStackTrace();
		}
		
	}

}
