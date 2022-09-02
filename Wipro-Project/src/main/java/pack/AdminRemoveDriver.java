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

@WebServlet("/AdminRemoveDriver")
public class AdminRemoveDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String userName=request.getParameter("Username");
		PrintWriter out=response.getWriter();
		try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			//System.out.println("hi1");
			Statement stmt=con.createStatement(); 
			String sql="delete from admindriverdetails where UserName=?;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.executeUpdate();
			String sql1="delete from driverdetails where UserName=?;";
			PreparedStatement ps1=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.executeUpdate();
			out.println("<center><h1 style=\"color:"+"red"+"\">Delete Successfully</h1></center>");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
			
	}

}
