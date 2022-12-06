package UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import DBUtility.DBUtil;
import Main.Main;
import Model.User;

public class Login {
	public User Islogin(String username,String password)throws LoginException {
		User user =null;
		

		try(Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from users where username = ? And password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name"); 
				boolean role = rs.getBoolean("role"); 
				String email = rs.getString("email"); 
				String phone = rs.getString("phone"); 
				user = new User(email,password,username,name,role,phone);
				System.out.println("login Successfull"+"\n");
				
			}else {
				System.out.println("Enter Correct Username/Password");
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Forgot your password then enter 1 ");
				System.out.println("Want to enter login details again then enter 2");
				
				int input = sc.nextInt();
				
				try {
					if(input==1) {
						ForgotPassword.forgotPassword();
					}else if(input==2){
						Main.main(null);
					}else {
						System.out.println("please choose a valid number");
					}
				}catch(InputMismatchException e) {
					System.out.println("invalid input");
				}
			}
			

		}catch(SQLException e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
			
		}
		
		return user;
	}

}
