package DBUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection provideConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db";
		
		try {
			conn = DriverManager.getConnection(url,"root", "Maya@(1996)");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}

}
