package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Suppliers;

public class SuppliersDAO {
	public static Suppliers getSupplierByID(int ID) throws SQLException{
		Suppliers supplier = new Suppliers();
		
		String sql = "Select * From Suppliers where SupplierID = ? ;";		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, ID);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			supplier.setSupplierID(result.getInt("SupplierID"));
			supplier.setSupplierName(result.getString("SupplierName"));
			supplier.setContactName(result.getString("ContactName"));
			supplier.setAddress(result.getString("Address"));
			supplier.setCity(result.getString("City"));
			supplier.setPostalCode(result.getString("PostalCode"));
			supplier.setCountry(result.getString("Country"));
			supplier.setPhone(result.getString("Phone"));
			
		}else {
			supplier = null;
		}
		
		return supplier;
	}
	
	public static Suppliers getSupplierByName(String name) throws SQLException{
		Suppliers supplier = new Suppliers();
		
		String sql = "Select * From Suppliers where SupplierName = ? ;";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setString(1, name);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			supplier.setSupplierID(result.getInt("SupplierID"));
			supplier.setSupplierName(result.getString("SupplierName"));
			supplier.setContactName(result.getString("ContactName"));
			supplier.setAddress(result.getString("Address"));
			supplier.setCity(result.getString("City"));
			supplier.setPostalCode(result.getString("PostalCode"));
			supplier.setCountry(result.getString("Country"));
			supplier.setPhone(result.getString("Phone"));
			
		}else {
			supplier = null;
		}
		
		return supplier;
	}
	
//	public static void main(String [] args) throws SQLException {
//		System.out.println( SuppliersDAO.getSupplierByName("Vu") );
//	}
}
