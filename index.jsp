<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@  page import="java.util.*"%>
<%@  page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	<%!String name = "";%>
	<%!int flag = 0;%>
	<%!int i; %>
	<%Set<String>	s1 = new HashSet<String>();%>
	
	<%
	
		if (application.getAttribute("name") == null) {
			application.setAttribute("name",name);
			s1.add(name);
		}
		
					
	name = application.getAttribute("name").toString();
	s1.add(name);
	
		
	%>
	
	 
	
	<%
		if (request.getParameter("txtName") != null) {
			name = request.getParameter("txtName");
			s1.add(name);
		}
		
		
	%>  
	<form action="" method="post">
		Product Name <input type="text" name="txtName"><br> 
				<input type="submit" value="print">
	</form>
	<hr>
	<h3> 
		 Suggtion :
		<% 
		s1.add(name);
			out.print(s1);
	
		 %>
		
	</h3>
	
		<%
	//for(i=0;i<s1.size();i++){
	application.setAttribute("name",name);
	//s1.add(name);
	//}
	
	%>
		
	
	


</body>
</html>
