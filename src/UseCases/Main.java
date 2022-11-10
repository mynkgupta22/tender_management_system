package UseCases;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import Dao.Login;
import Model.User;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username");
		String userName = sc.next();
		
		System.out.println("Enter Password");
		String passWord = sc.next();
		
		Login login = new Login();
		try {
			User user =login.Islogin(userName, passWord);
			System.out.println(user.getRole());
			String role= user.getRole();
			System.out.println(role);
			if(user !=null && role=="admin") {
				Admin admin = new Admin();
				admin.getStarted(user);
			}else if(user !=null && role=="Vendor") {
				Vendor vendor = new Vendor();
				vendor.getStarted(user);
			}else {
				System.out.println("Something went wrong");
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
