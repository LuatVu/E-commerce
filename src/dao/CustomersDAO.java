package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customers;

public class CustomersDAO {
	public static Customers getCustomerByID(int id) throws SQLException{
		Customers customer = new Customers();
		
		String sql = "select * from Customers where CustomerID = ?";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, id);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			customer.setCustomerID(result.getInt("CustomerID"));
			customer.setCustomerName(result.getString("CustomerName"));
			customer.setEmail(result.getString("Email"));
			customer.setAddress(result.getString("Address"));
			customer.setCity(result.getString("City"));
			customer.setPostalCode(result.getString("PostalCode"));
			customer.setCountry(result.getString("Country"));
		}else {
			customer = null;
		}
		
		return customer;
	}
	
	public static Customers getCustomerByName(String name) throws SQLException{
		Customers customer = new Customers();
		
		String sql = "select * from Customers where CustomerName = ?";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setString(1, name);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			customer.setCustomerID(result.getInt("CustomerID"));
			customer.setCustomerName(result.getString("CustomerName"));
			customer.setEmail(result.getString("Email"));
			customer.setAddress(result.getString("Address"));
			customer.setCity(result.getString("City"));
			customer.setPostalCode(result.getString("PostalCode"));
			customer.setCountry(result.getString("Country"));
		}else {
			customer = null;
		}
		
		return customer;
	}
}
