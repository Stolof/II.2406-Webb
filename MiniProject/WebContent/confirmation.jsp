<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>confirmation</title>
</head>
<body>

<% 
 if(session.getAttribute("loggedIn") == null){								// if not logged in go to Index.jsp
	  %> <jsp:forward page="Index.jsp"/>
    <%
 	} session.setAttribute("searchBook", null);
	%>

<h1> The booking for: <jsp:useBean id="current" type="login.service.Book" scope="request"/><%= current.getName()%> was
	<% 
	String status = "Not Sucessful";											// Simple if statement for displaying text
	if(current.isReserved()) {											
		status = "Sucessful";
	} %>
	<%= status %>
 </h1>

<form action="ResServlet" method="post">
	<input id="back" name="back" value="backbtn" type="hidden"> Back:
	<input type="submit" value="Back">
</form>

<form action="AuthServlet" method="post">
	<input id="logout" name="logout" value="logoutbtn" type="hidden">  logout:
	<input type="submit" value="Log out">
</form>

</body>
</html>