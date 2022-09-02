package pack;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminAddDriver")
public class AdminAddDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected String add(String DriverName,String placeofor,String Gender,String PhoneNumber,int Experience,String Licenseno,String UserName) {
    	Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");
		 
		//System.out.println("hi1");
		
		//Statement stmt=con.createStatement(); 
		String sql="Insert into admindriverdetails values(?,?,?,?,?,?,?);";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,DriverName);
		ps.setString(2,placeofor);
		ps.setString(3,Gender);
		ps.setString(4,PhoneNumber);
		ps.setInt(5,Experience);
		ps.setString(6,Licenseno);
		ps.setString(7,UserName);
		ps.executeUpdate();
		//ResultSet rs=ps.executeQuery();
		String sql1="delete from driverdetails where UserName=?;";
		PreparedStatement ps1=con.prepareStatement(sql1);
		ps1.setString(1, UserName);
		ps1.executeUpdate();
		//ResultSet rs1=ps1.executeQuery();
    	return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; 
    }
    protected String add1(String DriverName,String placeofor,String Gender,String PhoneNumber,int Experience,String Licenseno,String UserName) {
    	
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
			String sql="select * from driverdetails;";
			PreparedStatement ps=con.prepareStatement(sql);
			//ps.setString(1, user);
			
			ResultSet rs=ps.executeQuery();
			//String dn1 = rs.getString("DriverName");  
			System.out.println("hi4");
			
			//out.println("<html><body>");
			/*out.println("<script type=\"text/javascript\">\r\n"
					+ "            protected String add(String DriverName,String placeofor,String Gender,String PhoneNumber,int Experience,String Licenseno,String UserName) {\r\n"
					+ "            	Connection con;\r\n"
					+ "        		try {\r\n"
					+ "        			con = DriverManager.getConnection(\"jdbc:mysql://localhost:1521/proj\",\"root\",\"Harsha@6304243546\");\r\n"
					+ "        		 \r\n"
					+ "        		\r\n"
					+ "        		String sql=\"Insert into admindriverdetails values(?,?,?,?,?,?,?);\";\r\n"
					+ "        		PreparedStatement ps=con.prepareStatement(sql);\r\n"
					+ "        		ps.setString(1,DriverName);\r\n"
					+ "        		ps.setString(2,placeofor);\r\n"
					+ "        		ps.setString(3,Gender);\r\n"
					+ "        		ps.setString(4,PhoneNumber);\r\n"
					+ "        		ps.setInt(5,Experience);\r\n"
					+ "        		ps.setString(6,Licenseno);\r\n"
					+ "        		ps.setString(7,UserName);\r\n"
					+ "        		ps.executeUpdate();\r\n"
					+ "        		String sql1=\"DELETE FROM driverdetails WHERE UserName=\"+UserName+\";\";\r\n"
					+ "        		PreparedStatement ps1=con.prepareStatement(sql1);\r\n"
					+ "        		ps1.executeUpdate();\r\n"
					+ "            	return null;\r\n"
					+ "        		} catch (Exception e) {\r\n"
					+ "        			System.out.println(e.getMessage());\r\n"
					+ "        		}\r\n"
					+ "        		return null; \r\n"
					+ "            }\r\n"
					+ "            </script>");*/
			out.println("<table border=\"1\">");  
            out.println("<tr><th>DriverName</th><th>Place of Orgin</th><th>Gender</th><th>Phone Number</th><th>Experience</th><th>License Number</th><th>Username</th><th>Status</th></tr>");
             while(rs.next()) {
            
                String DriverName = rs.getString("DriverName");  
                String placeofor = rs.getString("placeofor"); 
                String Gender = rs.getString("Gender"); 
                String PhoneNumber = rs.getString("PhoneNumber"); 
                int Experience = rs.getInt("Experience"); 
                String Licenseno = rs.getString("Licenseno"); 
                String UserName = rs.getString("UserName");
                //out.println("</table>");  
                //out.println("<h1>"+DriverName+"</h1>");
                //<form name=\"f2\" action=\"AddDriver\" >"
        		//+ "                <input type=\"submit\" name=\"add\" value=\"ADD\" />"
        		//+ "               </form>
                out.println("<tr><td>"+DriverName+"</td><td>"+placeofor+"</td><td>"+Gender+"</td><td>"+PhoneNumber+"</td><td>"+Experience+"</td><td>"+Licenseno+"</td><td>"+UserName+"</td><td>"+"ADDED"+"</td></tr>");
            	/*request.setAttribute("DriverName",DriverName);
            	request.setAttribute("placeofor",placeofor);
            	request.setAttribute("Gender",Gender);
            	request.setAttribute("PhoneNumber",PhoneNumber);
            	request.setAttribute("Experience",Experience);
            	request.setAttribute("Licenseno",Licenseno);
            	request.setAttribute("UserName",UserName);
            	request.getRequestDispatcher("AdminAddDriverjsp.jsp").forward(request, response);*/
            	//out.println("<input type="+"button"+" value=\"Add\" onclick=\"add(DriverName,placeofor,Gender,PhoneNumber,Experience,Licenseno,UserName);\">");
                add(DriverName,placeofor,Gender,PhoneNumber,Experience,Licenseno,UserName);
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
