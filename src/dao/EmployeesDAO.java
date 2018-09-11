package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employees;

public class EmployeesDAO {
	
	public static Employees getEmployeeByID(int ID)throws SQLException {
		Employees employee = new Employees();
		
		String sql = "Select * From Employees Where EmployeeID = ?";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement pre = connect.prepareStatement(sql);
		pre.setInt(1, ID);
		ResultSet result = pre.executeQuery();
		
		if(result.next()) {
			employee.setEmployeeID(result.getInt("EmployeeID"));
			employee.setLastName(result.getString("LastName"));
			employee.setFirstName(result.getString("FirstName"));
			employee.setBirthDate(result.getDate("BirthDate"));
			employee.setPhotoPath(result.getString("Photo"));
			employee.setNote(result.getString("Note"));
		}else {
			employee = null;
		}
				
		return employee;
	}
	
	public static Employees getEmployeeByName(String name)throws SQLException {
		Employees employee = new Employees();
		
		String sql = "Select * From Employees Where LastName = ? Or FirstName = ?";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement pre = connect.prepareStatement(sql);
		pre.setString(1, name);
		pre.setString(2, name);
		ResultSet result = pre.executeQuery();
		
		if(result.next()) {
			employee.setEmployeeID(result.getInt("EmployeeID"));
			employee.setLastName(result.getString("LastName"));
			employee.setFirstName(result.getString("FirstName"));
			employee.setBirthDate(result.getDate("BirthDate"));
			employee.setPhotoPath(result.getString("Photo"));
			employee.setNote(result.getString("Note"));
		}else {
			employee = null;
		}
				
		return employee;
	}
}
