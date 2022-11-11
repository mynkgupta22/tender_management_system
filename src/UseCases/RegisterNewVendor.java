package UseCases;

import java.util.Scanner;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Model.User;
import UncheckedException.AdminException;

public class RegisterNewVendor {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the details below");
		System.out.println("Enter email id of the vendor");
		String email = sc.next();
		
		System.out.println("Enter email id of the vendor");
		String password = sc.next();
		
		System.out.println("Enter email id of the vendor");
		String username = sc.next();
		
		System.out.println("Enter email id of the vendor");
		String name = sc.next();
		
		
		boolean role = false;
		
		System.out.println("Enter phone number of the vendor");
		String phone = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		try {
			User user = dao.registerNewVendor(email, password, username, name, role, phone);
			
			System.out.println("Vendor's username is "+ user.getUsername() + "and password is "+user.getPassword());
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong, please try again");
		}
		
	}

}
