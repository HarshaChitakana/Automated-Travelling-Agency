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

@WebServlet("/AdminAddVehicle")
public class AdminAddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String add(String VehType,String VehName,String VehNum,String NoP) {
    	Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
		 
		
		String sql="Insert into adminvehicledetails values(?,?,?,?);";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,VehType);
		ps.setString(2,VehName);
		ps.setString(3,VehNum);
		ps.setString(4,NoP);
		ps.executeUpdate();
		//ResultSet rs=ps.executeQuery();
		String sql1="delete from driverdetails where UserName=?;";
		PreparedStatement ps1=con.prepareStatement(sql1);
		ps1.setString(1, VehNum);
		ps1.executeUpdate();
		//ResultSet rs1=ps1.executeQuery();
    	return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hi5");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		try {
	        Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			//System.out.println("hi1");
			
			Statement stmt=con.createStatement(); 
			String sql="select * from vehicledetails;";
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setString(1, user);
			
			ResultSet rs=ps.executeQuery();
			//String dn1 = rs.getString("DriverName");  
			System.out.println("hi4");
			
			
			out.println("<table border=\"1\">");  
            out.println("<tr><th>Vehicle Type</th><th>Vehicle Name</th><th>Vehicle Number</th><th>Number of Passenger</th><th>Status</th></tr>");
             while(rs.next()) {
            
                String VehType = rs.getString("VehType");  
                String VehName = rs.getString("VehName"); 
                String VehNum = rs.getString("VehNum"); 
                String NoP = rs.getString("NoP");
                out.println("<tr><td>"+VehType+"</td><td>"+VehName+"</td><td>"+VehNum+"</td><td>"+NoP+"</td><td>ADDED</td></tr>");
            	
                add(VehType,VehName,VehNum,NoP);
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