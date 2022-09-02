package pack;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminViewUser")
public class AdminViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
			
			String sql="select * from details;";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			out.println("<table border=\"1\">");  
            out.println("<tr><th>id</th><th>FullName</th><th>UserName</th><th>Gender</th><th>Email</th><th>Phone Number</th><th>accountNumber</th><th>License Number</th><th>ifscCode</th></tr>");
             while(rs.next()) {
            
                String id = rs.getString("id");  
                String FullName = rs.getString("FullName"); 
                String UserName = rs.getString("UserName"); 
                String Gender = rs.getString("Gender"); 
                String Email = rs.getString("Email"); 
                String PhoneNumber = rs.getString("PhoneNumber"); 
                String accountNumber = rs.getString("accountNumber"); 
                String ifscCode = rs.getString("ifscCode");
                
                out.println("<tr><td>"+id+"</td><td>"+FullName+"</td><td>"+UserName+"</td><td>"+Gender+"</td><td>"+Email+"</td><td>"+PhoneNumber+"</td><td>"+accountNumber+"</td><td>"+ifscCode+"</td></tr>");
            	
            	//out.println("<input type="+"button"+" value=\"Add\" onclick=\"add(DriverName,placeofor,Gender,PhoneNumber,Experience,Licenseno,UserName);\">");
                
             }
            out.println("</table>");  
            //out.println("</body></html>"); 
            con.close();
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
