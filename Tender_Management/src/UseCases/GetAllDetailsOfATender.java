package UseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.TenderDto;
import Model.User;
import UncheckedException.TenderException;

public class GetAllDetailsOfATender {
	
	public static void getAllDetailsOfATender(User user) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter tender_id to get the all details");
		int tender_id = sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			TenderDto tenderDetails = dao.getAllDetails(tender_id);
			System.out.println(tenderDetails);
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
