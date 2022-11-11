package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import DBUtility.DBUtil;
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
				System.out.println("login Successfull");
				
			}else {
				throw new LoginException("Enter Correct Username/Password");
			}
			

		}catch(SQLException e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
			
		}
		
		return user;
	}

}
