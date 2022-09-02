package pack;

import java.io.*;
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

@WebServlet("/AdminDetails")
public class AdminDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		String FullName=request.getParameter("FullName");
		
		String UserName=request.getParameter("UserName");
		String Gender=request.getParameter("Gender");
		String Email=request.getParameter("Email");
		String PhoneNumber=request.getParameter("PhoneNumber");
		String Password=request.getParameter("Password");
		String ConfirmPassword=request.getParameter("ConfirmPassword");
		String accountNumber=request.getParameter("accountNumber");
		String ifscCode=request.getParameter("ifscCode");
		
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		System.out.println(question+" "+answer);
		if(!(Password.equals(ConfirmPassword))) {
			out.write("Password and conform password should be same");
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			
			Statement stmt=con.createStatement(); 
			String sql="Insert into admindetails values(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,FullName);
			ps.setString(2,UserName);
			ps.setString(3,Gender);
			ps.setString(4,Email);
			ps.setString(5,PhoneNumber);
			ps.setString(6,Password);
			ps.setString(7,ConfirmPassword);
			ps.setString(8,accountNumber);
			ps.setString(9,ifscCode);
			ps.setString(10,question);
			ps.setString(11,answer);
			ps.executeUpdate();
			ResultSet rs=stmt.executeQuery("select * from details");
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}  
	}

}
