package pack;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminRemoveVehicle")
public class AdminRemoveVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String Vehnum=request.getParameter("Vehnum");
		PrintWriter out=response.getWriter();
		try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
			String sql="delete from adminvehicledetails where VehNum=?;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Vehnum);
			ps.executeUpdate();
			String sql1="delete from vehicledetails where VehNum=?;";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1, Vehnum);
			ps1.executeUpdate();
			out.println("<center><h1 style=\"color:"+"red"+"\">Delete Successfully</h1></center>");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
