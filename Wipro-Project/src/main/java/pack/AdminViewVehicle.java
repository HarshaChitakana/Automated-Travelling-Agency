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

@WebServlet("/AdminViewVehicle")
public class AdminViewVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
			
			String sql="select * from adminvehicledetails;";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			out.println("<table border=\"1\">");  
            out.println("<tr><th>Vehicle Type</th><th>Vehicle Name</th><th>Vehicle Number</th><th>Number of Passengers</th>");
             while(rs.next()) {
            
                String VehType = rs.getString("VehType");  
                String VehName = rs.getString("VehName"); 
                String VehNum = rs.getString("VehNum"); 
                String NoP = rs.getString("NoP"); 
                
                out.println("<tr><td>"+VehType+"</td><td>"+VehName+"</td><td>"+VehNum+"</td><td>"+NoP+"</td></tr>");
            	
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
