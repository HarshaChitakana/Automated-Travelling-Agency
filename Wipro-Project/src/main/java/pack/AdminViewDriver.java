package pack;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/AdminViewDriver")
public class AdminViewDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
			
			String sql="select * from admindriverdetails;";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			out.println("<table border=\"1\">");  
            out.println("<tr><th>DriverName</th><th>Place of Orgin</th><th>Gender</th><th>Phone Number</th><th>Experience</th><th>License Number</th><th>Username</th></tr>");
             while(rs.next()) {
            
                String DriverName = rs.getString("DriverName");  
                String placeofor = rs.getString("placeofor"); 
                String Gender = rs.getString("Gender"); 
                String PhoneNumber = rs.getString("PhoneNumber"); 
                int Experience = rs.getInt("Experience"); 
                String Licenseno = rs.getString("Licenseno"); 
                String UserName = rs.getString("UserName");
                
                out.println("<tr><td>"+DriverName+"</td><td>"+placeofor+"</td><td>"+Gender+"</td><td>"+PhoneNumber+"</td><td>"+Experience+"</td><td>"+Licenseno+"</td><td>"+UserName+"</td></tr>");
            	
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
