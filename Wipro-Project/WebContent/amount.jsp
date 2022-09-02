<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<form action="Welcome.html">
<input type="submit" value="Home">
<center>
<h1 style="color:green">Payment Success</h1>

</center>
<script type="text/javascript">
<%String amountStr = (String)request.getAttribute("amountStr"); 
//System.out.println(amountStr);%>

if(window.alert("Transport Charges: "+<%=amountStr%>)== true){
	
}
else{
	<% %>
}
</script>
</form>
</body>
</html>