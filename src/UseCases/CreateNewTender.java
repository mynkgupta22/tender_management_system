package UseCases;

import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.User;
import UncheckedException.AdminException;
import UncheckedException.TenderException;

public class CreateNewTender {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the details to create new tender");
		
		
		System.out.println("Enter tender id of the tender");
		int id = sc.nextInt();
		
		System.out.println("Enter start date of the Tender");
		String start_date = sc.next();
		
		
	
		System.out.println("Enter last date of the Tender");
		String last_date = sc.next();
		
		
	
		
		
		//boolean status = true;
		
		System.out.println("Enter name of the tender");
		String tender_name = sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		try {
			String s = dao.createNewTender(id, start_date, last_date,  tender_name);
			
			
			
		} catch (TenderException e) {
			
			System.out.println("Something went wrong, please try again");
		}

	}

}
