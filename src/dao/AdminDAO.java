package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDAO {
	public static Admin getAdminByName(String name) throws SQLException {
		
		Admin admin = new Admin();
		
		String sql = "Select * From Admin Where AdminName = ? ;"; 
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setString(1, name);
		ResultSet result = prepare.executeQuery();
		
		if( result.next() ) {
			admin.setAdminID(result.getInt("AdminID"));
			admin.setAdminName(result.getString("AdminName"));
			admin.setPassWord(result.getString("Password"));			
		}else {
			admin = null;
		}
		return admin;
	}
	
//	public static void main(String[] args) throws SQLException {
//		Admin admin = AdminDAO.getAdminByName("Admin");
//		if(admin != null)
//			System.out.println(admin.getAdminName());
//		else 
//			System.out.println("Admin is Null");
//	}
	
	
}
