package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Shippers;

public class ShippersDAO {
	public static Shippers getShipperByID(int ID) throws SQLException{
		Shippers shipper = new Shippers();
		
		String sql = "Select * From Shippers Where ShipperID = ?; ";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, ID);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			shipper.setShipperID(result.getInt("ShipperID"));
			shipper.setShipperName(result.getString("ShipperName"));
			shipper.setPhone(result.getString("Phone"));
		}else {
			shipper = null;
		}
		
		return shipper;
	}
	
	public static Shippers getShipperByName(String name) throws SQLException{
		Shippers shipper = new Shippers();
		
		String sql = "Select * From Shippers Where ShipperName = ?; ";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setString(1, name);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			shipper.setShipperID(result.getInt("ShipperID"));
			shipper.setShipperName(result.getString("ShipperName"));
			shipper.setPhone(result.getString("Phone"));
		}else {
			shipper = null;
		}
		
		return shipper;
	}
}
