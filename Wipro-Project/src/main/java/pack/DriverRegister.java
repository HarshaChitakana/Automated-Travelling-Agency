package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DriverRegister")
public class DriverRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("html/text");
		PrintWriter out=response.getWriter();
		Random r=new Random();
	      StringBuffer sb=new StringBuffer("");
	      char c=(char)(r.nextInt(26)+'a');
	      sb.append((char)(r.nextInt(26)+'a'));
	      sb.append((char)(r.nextInt(26)+'a'));
	      sb.append((char)(r.nextInt(26)+'a'));
	      sb.append(r.nextInt(10));
	      sb.append(r.nextInt(10));
	      String id=String.valueOf(sb);
		String DriverName=request.getParameter("DriverName");
		String pofo=request.getParameter("pofo");
		
		String Gender=request.getParameter("Gender");
		String PhoneNumber=request.getParameter("PhoneNumber");
		
		String Experience=request.getParameter("Experience");
		String License=request.getParameter("License");
		String UserName=request.getParameter("UserName");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			
			Statement stmt=con.createStatement(); 
			String sql="Insert into driverdetails values(?,?,?,?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,DriverName);
			ps.setString(2,pofo);
			ps.setString(3,Gender);
			ps.setString(4,PhoneNumber);
			ps.setString(5,Experience);
			ps.setString(6,License);
			ps.setString(7,UserName);
			ps.executeUpdate();
			ResultSet rs=stmt.executeQuery("select * from details");
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}  
	}

}
