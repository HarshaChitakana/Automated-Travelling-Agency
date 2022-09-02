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

@WebServlet("/Adminvalidation")
public class Adminvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
			Statement stmt=con.createStatement();
			String user=request.getParameter("UserName1");
			String question=request.getParameter("question1");
			String answer=request.getParameter("answer1");
			PrintWriter p=response.getWriter();
			System.out.println(user+" "+question+" "+answer);
			PreparedStatement st=con.prepareStatement("select * from admindetails where UserName=?;");
			st.setString(1, user);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				String dQuestion=rs.getString(10);
				String dAnswer=rs.getString(11);
				//con.close(); 
				//System.out.println(dQuestion+" "+dAnswer+" "+question+" "+answer);
				if(dQuestion.equals(question) && dAnswer.equals(answer)) {
					response.sendRedirect("adminchangepass.html");  
					//System.out.println(dQuestion);
				}
				else {
					p.println("<h1>incorrect Details</h1>");
					response.sendRedirect("adminsecurity.html"); 
				}
			}
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
