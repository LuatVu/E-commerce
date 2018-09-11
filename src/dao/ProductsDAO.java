package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Products;
import model.Suppliers;
import model.Categories;
import model.Color;

import java.util.ArrayList;

public class ProductsDAO {
	
	public static Products getProductByID(int ID) throws SQLException{
		Products product = new Products();		
		
		String sql = "Select * From Products Where ProductID = ? ;";		
		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, ID);
		ResultSet result = prepare.executeQuery();
		
		while(result.next()) {			
			Suppliers supplier;
			Categories category;
			ArrayList<Color> colorList;
			
			supplier = SuppliersDAO.getSupplierByID(result.getInt("SupplierID"));
			category = CategoriesDAO.getCategoryByID(result.getInt("CategoryID"));
			colorList = ColorDAO.getColorsByProductID(result.getInt("ProductID"));
			
			product.setProductID(result.getInt("ProductID"));
			product.setProductName(result.getString("ProductName"));
			product.setSupplier(supplier);
			product.setCategory(category);
			product.setColorList(colorList);
			product.setUnit(result.getString("Unit"));
			product.setPrice(result.getDouble("Price"));
			product.setSize(result.getString("size")); // Size
			product.setGender(result.getBoolean("Gender"));
			product.setImagePath(result.getString("ImagePath"));
						
			
		}
		return product;
	}
	
	public static ArrayList<Products> getAllProducts() throws SQLException{
		ArrayList<Products> productList = new ArrayList<>();		
		
		String sql = "Select * From Products";		
		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		ResultSet productResult = prepare.executeQuery();
		
		while(productResult.next()) {
			Products product = new Products(); 
			Suppliers supplier;
			Categories category;
			ArrayList<Color> colorList;
			
			supplier = SuppliersDAO.getSupplierByID(productResult.getInt("SupplierID"));
			category = CategoriesDAO.getCategoryByID(productResult.getInt("CategoryID"));
			colorList = ColorDAO.getColorsByProductID(productResult.getInt("ProductID"));
			
			product.setProductID(productResult.getInt("ProductID"));
			product.setProductName(productResult.getString("ProductName"));
			product.setSupplier(supplier);
			product.setCategory(category);
			product.setColorList(colorList);
			product.setUnit(productResult.getString("Unit"));
			product.setPrice(productResult.getDouble("Price"));
			product.setSize(productResult.getString("size")); // Size
			product.setGender(productResult.getBoolean("Gender"));
			product.setImagePath(productResult.getString("ImagePath"));
			
			productList.add(product);
			
		}
		return productList;
	}
	
	
	public static ArrayList<Products> getProductsByCategory(int categoryID) throws SQLException{
		ArrayList<Products> productList = new ArrayList<>();
		
		String sql = "Select * From Products inner join Categories "
				+ " on Products.CategoryID = Categories.CategoryID "
				+ " Where Products.CategoryID = ? ;";		
		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, categoryID);
		ResultSet productResult = prepare.executeQuery();
		
		Categories category;
		category = CategoriesDAO.getCategoryByID( categoryID );
		
		while(productResult.next()) {
			Products product = new Products(); 
			Suppliers supplier;
			
			ArrayList<Color> colorList;
			
			supplier = SuppliersDAO.getSupplierByID(productResult.getInt("SupplierID"));			
			colorList = ColorDAO.getColorsByProductID(productResult.getInt("ProductID"));
			
			product.setProductID(productResult.getInt("ProductID"));
			product.setProductName(productResult.getString("ProductName"));
			product.setSupplier(supplier);
			product.setCategory(category);
			product.setColorList(colorList);
			product.setUnit(productResult.getString("Unit"));
			product.setPrice(productResult.getDouble("Price"));
			product.setSize(productResult.getString("size")); // Size
			product.setGender(productResult.getBoolean("Gender"));
			product.setImagePath(productResult.getString("ImagePath"));
			
			productList.add(product);
			
		}
		
		return  productList;
	}
	
	public static ArrayList<Products> getProductsByGender(Boolean gender) throws SQLException{
		ArrayList<Products> productList = new ArrayList<>();
		
		String sql = "Select * From Products Where Gender = b?; ";	
		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setString(1, gender?"1":"0" );
		ResultSet productResult = prepare.executeQuery();
		
		
		
		
		while(productResult.next()) {
			Products product = new Products(); 
			Suppliers supplier;
			Categories category;			
			ArrayList<Color> colorList;
			
			supplier = SuppliersDAO.getSupplierByID(productResult.getInt("SupplierID"));
			category = CategoriesDAO.getCategoryByID(productResult.getInt("CategoryID"));
			colorList = ColorDAO.getColorsByProductID(productResult.getInt("ProductID"));
			
			product.setProductID(productResult.getInt("ProductID"));
			product.setProductName(productResult.getString("ProductName"));
			product.setSupplier(supplier);
			product.setCategory(category);
			product.setColorList(colorList);
			product.setUnit(productResult.getString("Unit"));
			product.setPrice(productResult.getDouble("Price"));
			product.setSize(productResult.getString("size")); // Size
			product.setGender(productResult.getBoolean("Gender"));
			product.setImagePath(productResult.getString("ImagePath"));
			
			productList.add(product);
			
		}
		
		return  productList;
	}
	
	public static ArrayList<Products> getProductsByColor(int colorID) throws SQLException{
		ArrayList<Products> productList = new ArrayList<>();
		
		String sql = "Select * From Products Inner join Color_Product "
				+ " on Products.ProductID = Color_Product.ProductID "
				+ " where Color_Product.ColorID = ?";

		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		prepare.setInt(1, colorID);
		ResultSet productResult = prepare.executeQuery();
					
		
		while(productResult.next()) {
			Products product = new Products(); 
			Suppliers supplier;
			Categories category;			
			ArrayList<Color> colorList;
			
			supplier = SuppliersDAO.getSupplierByID(productResult.getInt("SupplierID"));
			category = CategoriesDAO.getCategoryByID(productResult.getInt("CategoryID"));
			colorList = ColorDAO.getColorsByProductID(productResult.getInt("ProductID"));
			
			product.setProductID(productResult.getInt("ProductID"));
			product.setProductName(productResult.getString("ProductName"));
			product.setSupplier(supplier);
			product.setCategory(category);
			product.setColorList(colorList);
			product.setUnit(productResult.getString("Unit"));
			product.setPrice(productResult.getDouble("Price"));
			product.setSize(productResult.getString("size")); // Size
			product.setGender(productResult.getBoolean("Gender"));
			product.setImagePath(productResult.getString("ImagePath"));
			
			productList.add(product);
			
		}
		
		return  productList;
	}
	
	public static ArrayList<Products> getProductsByPrice(double lower, double price) throws SQLException{
		
		ArrayList<Products> productList = new ArrayList<>();
		
		String sql = "Select * From Products "
				+ " Where price between ? and ?; ";
		
		Connection connect = ConnectDatabase.getConnection();
		PreparedStatement prepare = connect.prepareStatement(sql);
		
		prepare.setDouble(1, lower);
		prepare.setDouble(2, price);
				
		ResultSet productResult = prepare.executeQuery();
							
		while(productResult.next()) {
			Products product = new Products(); 
			Suppliers supplier;
			Categories category;			
			ArrayList<Color> colorList;
			
			supplier = SuppliersDAO.getSupplierByID(productResult.getInt("SupplierID"));
			category = CategoriesDAO.getCategoryByID(productResult.getInt("CategoryID"));
			colorList = ColorDAO.getColorsByProductID(productResult.getInt("ProductID"));
			
			product.setProductID(productResult.getInt("ProductID"));
			product.setProductName(productResult.getString("ProductName"));
			product.setSupplier(supplier);
			product.setCategory(category);
			product.setColorList(colorList);
			product.setUnit(productResult.getString("Unit"));
			product.setPrice(productResult.getDouble("Price"));
			product.setSize(productResult.getString("size")); // Size
			product.setGender(productResult.getBoolean("Gender"));
			product.setImagePath(productResult.getString("ImagePath"));
			
			productList.add(product);
			
		}
		
		return  productList;
	}
	
		
	
	
////	
	public static void main(String [] args) throws SQLException{
		Products product = ProductsDAO.getProductByID(3);
		//for (Products product : productList) {
			ArrayList<Color> colorList;
			System.out.println(product.getProductName());
			colorList = product.getColorList();
			for(Color color: colorList) {
				System.out.print(color.getColor() + " ");
			}
			System.out.println("");
		//}
	}
		
}
