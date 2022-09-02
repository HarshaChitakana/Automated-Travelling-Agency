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

@WebServlet("/AdminPassChange")
public class AdminPassChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String password=request.getParameter("Password");
		String user=request.getParameter("UserName");
		PrintWriter p=response.getWriter();
		try{
			//Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			
			Statement stmt=con.createStatement();
			
			PreparedStatement st=con.prepareStatement("update admindetails set Password=? where UserName=?; ");
			st.setString(1, password);
			st.setString(2, user);
			st.executeUpdate();
			PreparedStatement st1=con.prepareStatement("update admindetails set ConfirmPassword=? where UserName=?; ");
			st1.setString(1, password);
			st1.setString(2, user);
			st1.executeUpdate();
			con.close();
			response.sendRedirect("adminwelcome.html");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}  
	}
}


