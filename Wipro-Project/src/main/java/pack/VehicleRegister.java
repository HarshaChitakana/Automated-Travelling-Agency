package pack;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VehicleRegister")
public class VehicleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hi");
		String vehicletype=request.getParameter("vehicletype");
		String vehiclename=request.getParameter("vehiclename");
		
		String vnumber=request.getParameter("vnumber");
		String passengers=request.getParameter("passengers");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			
			Statement stmt=con.createStatement(); 
			String sql="Insert into vehicledetails values(?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,vehicletype);
			ps.setString(2,vehiclename);
			ps.setString(3,vnumber);
			ps.setString(4,passengers);
			ps.executeUpdate();
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}  
	}

}
