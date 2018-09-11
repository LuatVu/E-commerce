package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.OrderDetails;
import model.Products;

public class OrderDetailsDAO {
	
	public static OrderDetails getOrderDetailByID(int ID) throws SQLException{
		OrderDetails orderDetail = new OrderDetails();
		
		String sql = "Select * From OrderDetails Where OrderDetailID = ? ; ";
		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, ID);
		ResultSet result = prepare.executeQuery();
		
		if(result.next()) {
			Products product = ProductsDAO.getProductByID(result.getInt("ProductID"));
			
			orderDetail.setOrderDetailID(ID);			
			orderDetail.setQuantity(result.getInt("Quantity"));
			orderDetail.setProduct(product);			
		}else {
			orderDetail = null;
		}
		
		return orderDetail;
		
	}
}
