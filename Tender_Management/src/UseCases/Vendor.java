package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Main.Main;
import Model.User;

public class Vendor {
	public static void getStarted(User user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+user.getName()+"\n");
		System.out.println("+----------------------------------+");
		System.out.println("| 1. View all the current Tenders  |");
		System.out.println("| 2. Place a Bid against a Tender  |");
		System.out.println("| 3. View status of a Bid          |");
		System.out.println("| 4. View Bid History              |");
		System.out.println("| 5. Back                          |");
		System.out.println("| 6. LogOut/Exit                   |");
		System.out.println("+----------------------------------+");
		
		
		int input = sc.nextInt();
		try {
			switch(input) {
		     case 1 :{
			     ViewAllCurrentTender.viewAllCurrentTender(user);
		     }
		     break;
		     case 2 :{
		    	 PlaceABid.placeABid(user);
		     }
		     break;
		     case 3 :{
		    	 BidStatus.bidStatus(user);
		     }
		     break;
		     case 4:{
		    	 ViewAllBidsHistory.viewAllBidsHistory(user);
		     }
		     break;
		     case 5:{
		    	 Main.main(null);
		     }
		     break;
		     case 6:{
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
		
	}

}
