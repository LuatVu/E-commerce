package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import dao.ProductsDAO;
import model.Products;

import java.util.ArrayList;


public class ProductsController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		ArrayList <Products> productList = new ArrayList<>(); 
		
		String category;
		String price;
		String gender;
		String color;
		
		category = request.getParameter("category");
		switch(category) {
		case "All": try {
				productList = ProductsDAO.getAllProducts();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		case "Dresses": ;
		case "Watches": ;
		case "Bags": ;
		case "Sunglasses": ;
		case "FooterWear": ;
		}
		request.setAttribute("productList", productList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product.jsp");
		requestDispatcher.forward(request, response);
	}
	
	
		
}
