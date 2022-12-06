package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Main.Main;
import Model.User;

public class Admin {
	public static void getStarted(User user) {
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.println(" Welcome "+user.getName()+"\n");
		System.out.println("+---------------------------------------+");
		System.out.println("| 1. Register new Vendor                |");
		System.out.println("| 2. Register new Admin                 |");
		System.out.println("| 3. View all the vendors               |");
		System.out.println("| 4. Create new tenders                 |");
		System.out.println("| 5. View all the Tenders               |");
		System.out.println("| 6. View All the Bids of a tender      |");
		System.out.println("| 7. Assign tender to a vendor          |");
		System.out.println("| 8. See all biding details of a tender |");
		System.out.println("| 9. Back                               |");
		System.out.println("| 10. LogOut/Exit                       |");
		System.out.println("+---------------------------------------+");
		
		  
	    int input = sc.nextInt();
		
		try {
			switch(input) {
		     case 1 :{
			      RegisterNewVendor.registerNewVendor(user);
		     }
		     break;
		     case 2 :{
		    	 RegisterNewAdmin.registerNewAdmin(user);
		     }
		     break;
		     case 3 :{
		    	 ViewAllVendors.viewAllVendors(user);
		     }
		     break;
		     case 4:{
		    	 CreateNewTender.createNewTender(user);
		     }
		     break;
		     case 5:{
		    	 ViewAllTender.viewAllTender(user);
		     }
		     break;
		     case 6:{
		    	 ViewAllBidsOfATender.viewAllBidsOfATender(user);
		     }
		     break;
		     case 7:{
		    	 AssignTenderToVendor.assignTenderToVendor(user);
		     }
		     break;
		     case 8:{
		    	 GetAllDetailsOfATender.getAllDetailsOfATender(user);
		     }
		     break;
		     case 9:{
		    	 Main.main(null); 
		     }
		     break;
		     case 10:{
		    	 System.out.println("Thank you");
		    	 System.exit(0); 
		     }
		     break;
		     default :{
		    	 System.out.println( "Please choose a number from below options");
		    	 Admin.getStarted(user);
		     }
		}
		}catch(InputMismatchException e) {
			System.out.println( "Input type should be a number");
			Admin.getStarted(user);
		}
		
		
		
		
		
		
	}

}
