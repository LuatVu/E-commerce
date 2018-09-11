package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException ex) {			
		}
	}
	public static Connection getConnection() throws SQLException{		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/ShoppingStore","luat","0366511554Ll");
	}
	
//	public static void main(String[] args) throws SQLException {
//		System.out.println(ConnectDatabase.getConnection());
//	}
	
}
