package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Color;
import java.util.ArrayList;

public class ColorDAO {
	public static Color getColorByID(int id) throws SQLException{
		Color color = new Color();
		
		String sql = "Select * From Color where ColorID = ?; ";
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement ps = connect.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet result = ps.executeQuery();
		if (result.next()) {
			color.setColorID(result.getInt("ColorID"));
			color.setColor(result.getString("Color"));
		}else {
			color = null;
		}
		
		return color;
	}
	
	public static ArrayList<Color> getColorsByProductID(int productID) throws SQLException{
		ArrayList<Color> colorList = new ArrayList<>();
		
		String sql = "Select * From Color "
				+ " Inner Join Color_Product "
				+ " on Color.ColorID = Color_Product.ColorID "
				+ " Where Color_Product.ProductID = ?; ";		
		Connection connect = ConnectDatabase.getConnection();
		
		PreparedStatement pre = connect.prepareStatement(sql);
		pre.setInt(1, productID);
		ResultSet result = pre.executeQuery();
		
		while(result.next()) {
			Color color = new Color();
			color.setColorID(result.getInt("ColorID"));
			color.setColor(result.getString("Color"));
			colorList.add(color);
		}
		
		return colorList;
	}
	
	public static void main(String [] args) throws SQLException{
		ArrayList<Color> colorList = ColorDAO.getColorsByProductID(1);
		for(Color color : colorList) {
			System.out.println(color.getColor());
		}
	}
		
}
