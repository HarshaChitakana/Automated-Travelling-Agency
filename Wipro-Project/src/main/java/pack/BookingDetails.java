package pack;
import java.util.*;
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

@WebServlet("/BookingDetails")
public class BookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static String captalize(String s) {
		char[] c=s.toCharArray();
		c[0]=Character.toUpperCase(c[0]);
		String s1=String.valueOf(c);
		return s1;
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		String pickUp=request.getParameter("Pickup");
		String drop=request.getParameter("Drop");
		String journey=request.getParameter("Journey");
		String date=request.getParameter("date&time");
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1521/proj","root","Harsha@6304243546");  
			
			Statement stmt=con.createStatement(); 
			String sql="Insert into BookingDetails values(?,?,?,?,?);";
			String user=request.getParameter("Username");
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,pickUp);
			ps.setString(2,drop);
			ps.setString(3,journey);
			ps.setString(4,date);
			ps.setString(5,user);
			ps.executeUpdate();
			ArrayList<String> startDest=new ArrayList<String>();
			startDest.add("Delhi-Dehradun");
			startDest.add("Delhi-Agra");
			startDest.add("Delhi-Amritsar");
			startDest.add("Delhi-Rishikesh");
			startDest.add("Delhi-Mathura");
			startDest.add("Delhi-Chandigarh");
			startDest.add("Delhi-Jaipur");
			startDest.add("Delhi-Nainital");
			startDest.add("Delhi-Gwalior");
			startDest.add("Delhi-Dharamshala");
			startDest.add("Agra-Dharamshala");
			startDest.add("Agra-Jaipur");
			startDest.add("Agra-Gwalior");
			startDest.add("Agra-Nainital");
			startDest.add("Agra-Dehradun");
			startDest.add("Agra-Amritsar");
			startDest.add("Agra-Chandigarh");
			startDest.add("Agra-Mathura");
			startDest.add("Agra-Rishikesh");
			startDest.add("Dehradun-Amritsar");
			startDest.add("Dehradun-Rishikesh");
			startDest.add("Dehradun-Mathura");
			startDest.add("Dehradun-Jaipur");
			startDest.add("Dehradun-Dharamshala");
			startDest.add("Dehradun-Gwalior");
			startDest.add("Dehradun-Nainital");
			startDest.add("Dehradun-Chandigarh");
			startDest.add("Amritsar-Chandigarh");
			startDest.add("Amritsar-Rishikesh");
			startDest.add("Amritsar-Mathura");
			startDest.add("Amritsar-Jaipur");
			startDest.add("Amritsar-Nainital");
			startDest.add("Amritsar-Gwalior");
			startDest.add("Amritsar-Dharamshala");
			startDest.add("Rishikesh-Mathura");
			startDest.add("Rishikesh-Chandigarh");
			startDest.add("Rishikesh-Jaipur");
			startDest.add("Rishikesh-Nainita");
			startDest.add("Rishikesh-Gwalior");
			startDest.add("Rishikesh-Dharamshala");
			startDest.add("Mathura-Chandigarh");
			startDest.add("Mathura-Jaipur");
			startDest.add("Mathura-Nainital");
			startDest.add("Mathura-Gwalior");
			startDest.add("Mathura-Dharamshala");
			startDest.add("Chandigarh-Jaipur");
			startDest.add("Chandigarh-Nainital");
			startDest.add("Chandigarh-Gwalior");
			startDest.add("Chandigarh-Dharamshala");
			startDest.add("Jaipur-Nainital");
			startDest.add("Jaipur-Gwalior");
			startDest.add("Jaipur-Dharamshala");
			startDest.add("Nainital-Gwalior");
			startDest.add("Nainital-Dharamshala");
			startDest.add("Gwalior-Dharamshala");
			
			startDest.add("amritsar-rishikesh");
			ArrayList<Integer> distance=new ArrayList<Integer>();
			distance.add(276);
			distance.add(250);
			distance.add(443);
			distance.add(240);
			distance.add(180);
			distance.add(290);
			distance.add(268);
			distance.add(285);
			distance.add(363);//delhi-gwalior
			distance.add(463);
			distance.add(707);
			distance.add(240);
			distance.add(120);
			distance.add(351);
			distance.add(434);
			distance.add(686);
			distance.add(482);
			distance.add(57);
			distance.add(418);
			distance.add(429);
			distance.add(45);
			distance.add(386);
			distance.add(523);
			distance.add(448);
			distance.add(555);
			distance.add(286);
			distance.add(220);
			distance.add(232);
			distance.add(443);
			distance.add(635);
			distance.add(653);
			distance.add(658);
			distance.add(816);
			distance.add(201);
			distance.add(365);
			distance.add(258);
			distance.add(546);
			distance.add(431);
			distance.add(222);
			distance.add(428);
			distance.add(174);
			distance.add(658);
			distance.add(482);
			distance.add(452);
			distance.add(611);
			distance.add(268);
			distance.add(559);
			distance.add(332);
			distance.add(702);
			distance.add(472);
			distance.add(700);
			distance.add(837);
			distance.add(472);
			distance.add(472);
			StringBuffer sb=new StringBuffer("");
			String pick=captalize(pickUp);
			String droping=captalize(drop);
			sb.append(pick);
			sb.append("-");
			sb.append(droping);	
			String stde=String.valueOf(sb);
			StringBuffer sb1=new StringBuffer("");
			sb1.append(droping);
			sb1.append("-");
			sb1.append(pick);
			String stde1=String.valueOf(sb1);
			int amount=0;
			System.out.println(stde);
			System.out.println(stde1);
			System.out.println(startDest.get(5));
			if(startDest.contains(stde1)) {
				
				if(journey.equals("Roundtrip")) {
					amount=40*distance.get(startDest.indexOf(stde1));
				}else {
					amount=50*distance.get(startDest.indexOf(stde1));
				}
				System.out.println(stde1);
			}
			else if(startDest.contains(stde)) {
				if(journey.equals("Roundtrip")) {
					amount=40*distance.get(startDest.indexOf(stde));
				}else {
					amount=50*distance.get(startDest.indexOf(stde));
				}
				System.out.println(stde);
			}
			System.out.println(amount);
			String amountStr=String.valueOf(amount);
			//System.out.println(amountStr);
			request.setAttribute("amountStr",amountStr);
			request.getRequestDispatcher("/amount.jsp").forward(request, response); 
			//response.sendRedirect("amountconfirm.html");
			//p.write("<html><body><form><script type="+"text/javascript"+">window.alert("+"amount"+");</script></form></body></html>");
			con.close(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}  
	}

}
