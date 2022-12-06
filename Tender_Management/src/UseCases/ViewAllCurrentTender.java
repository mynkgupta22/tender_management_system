package UseCases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Dao.VendorDao;
import Dao.VendorDaoImpl;
import Model.Tender;
import Model.User;
import UncheckedException.TenderException;

public class ViewAllCurrentTender {

	public static void viewAllCurrentTender(User user)  {
	
        VendorDao dao = new VendorDaoImpl();
		
		try {
			
			List<Tender> tenders = new ArrayList<>(dao.viewAllCurrentTender());
			if(tenders.isEmpty()) {
				System.out.println("Sorry! There is no current tenders available.");
				Vendor.getStarted(user);
			}
			
			tenders.forEach(t -> System.out.println(t));
			
			System.out.println("\n"+"\n");
			System.out.println("1. Back");
			System.out.println("2. LogOut/Exit");
			Scanner sc = new Scanner(System.in);
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
			    	 System.out.println( "Please choose a number from below options");
			    	 Vendor.getStarted(user);
			     }
			}
			}catch(InputMismatchException e) {
				System.out.println( "Input type should be a number");
				Vendor.getStarted(user);
			}
			
		} catch (TenderException e) {
			
			e.printStackTrace();
		}
	}

}
