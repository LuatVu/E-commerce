package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Categories;

public class CategoriesDAO {
	
	public static Categories getCategoryByID(int  ID)  throws SQLException{
		Categories category = new Categories();
		
		String sql = "Select * From Categories Where CategoryID = ?";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, ID);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			category.setCategoryID(result.getInt("CategoryID"));
			category.setCategoryName(result.getString("CategoryName"));
			category.setDescription(result.getString("Description"));
		}else {
			category = null;
		}
		
		return category;
	}
	
	public static Categories getCategoryByName(String name) throws SQLException{
		Categories category = new Categories();
		
		String sql = "Select * From Categories where CategoryName = ?";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setString(1, name);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			category.setCategoryID(result.getInt("CategoryID"));
			category.setCategoryName(result.getString("CategoryName"));
			category.setDescription(result.getString("Description"));
		}else {
			category = null;
		}
		
		return category;
	}
	
}
