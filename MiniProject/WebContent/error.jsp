<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error page</title>
</head>
<body>

<% 
 if(session.getAttribute("loggedIn") == null){				// if not logged in go to Index.jsp
	  %> <jsp:forward page="Index.jsp"/>
    <%
 	} session.setAttribute("searchBook", null);
	%>

<h1>Error page!</h1>
Get back to login page: 
<a href="http://localhost:8080/MiniProject/" > Login</a>

</body>
</html>