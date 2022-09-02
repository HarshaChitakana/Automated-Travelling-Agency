package pack;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
	        
	        String user = request.getParameter("Username");
	        String pass = request.getParameter("Password");
	        
	        try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			
			Statement stmt=con.createStatement(); 
			String sql="select * from details where Username=?;";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String usern=rs.getString("Username");
			String passw=rs.getString("Password");
	        if(usern.equals(user) && pass.equals(passw))
	        {
	            RequestDispatcher r = request.getRequestDispatcher("Booking.html");
	            r.forward(request, response);
	        }
	        else
	        {
	           out.println("<html><p style="+"color:red"+">Incorrect Username or password</html>");
	           RequestDispatcher r = request.getRequestDispatcher("Login.html");
	           r.include(request, response);
	        }
	        con.close();
	        }
	        catch(Exception e) {
	        	System.out.println(e.getMessage());
	        }
	}

}
