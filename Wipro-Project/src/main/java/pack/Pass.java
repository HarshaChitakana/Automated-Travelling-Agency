package pack;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pass")
public class Pass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("html/text");
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
			Statement stmt=con.createStatement();
			String user=request.getParameter("UserName");
			String question=request.getParameter("question");
			String answer=request.getParameter("answer");
			PrintWriter p=response.getWriter();
			PreparedStatement st=con.prepareStatement("select * from details where UserName=?;");
			st.setString(1, user);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				String dQuestion=rs.getString(11);
				String dAnswer=rs.getString(12);
				//con.close(); 
				//System.out.println(dQuestion+" "+dAnswer+" "+question+" "+answer);
				if(dQuestion.equals(question) && dAnswer.equals(answer)) {
					response.sendRedirect("ChangePass.html");  
					//System.out.println(dQuestion);
				}
				else {
					p.println("<h1>incorrect Details</h1>");
					response.sendRedirect("forgetpass.html"); 
				}
			}
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
