package UseCases;

import java.sql.SQLException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import Dao.AdminDao;
import Dao.AdminDaoImpl;
import Main.Main;
import UncheckedException.AdminException;

public class ForgotPassword {
	public static void forgotPassword() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the email id");
		String email = sc.next();
		
		System.out.println("Please enter the phone number");
		String phone = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		String password;
		try {
			password = dao.getPassword(email, phone);
			System.out.println("Your password is "+password);
			
			Main.main(null);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
