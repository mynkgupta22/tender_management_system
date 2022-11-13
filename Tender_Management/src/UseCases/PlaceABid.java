package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.VendorDao;
import Dao.VendorDaoImpl;
import Model.User;
import UncheckedException.TenderException;

public class PlaceABid {

	public static void placeABid(User user) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the details to create new tender");
		
		
		System.out.println("Enter tender id from above List");
		int tender_id = sc.nextInt();
		

		System.out.println("Enter biding amount");
		double bid_amount = sc.nextInt();
		
		String vendor_email = user.getEmail(); 
		
		
		VendorDao dao = new VendorDaoImpl();
		
		try {
			String result = dao.placeABiding(tender_id, bid_amount, vendor_email);
			System.out.println(result);
			
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
			    	 Vendor.getStarted(user);
			     }
			}
			}catch(InputMismatchException e) {
				System.out.println( "Input type should be a number");
				Vendor.getStarted(user);
			}
			
			
		} catch (TenderException e) {
			
			System.out.println("Something went wrong, please try again");
		}
		
		

	}

}
