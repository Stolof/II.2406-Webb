<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>goodbye</title>
</head>
<body>

<% 
 if(session.getAttribute("loggedIn") == null){ 				// if not loggedIn go to Index.jsp
	  %> <jsp:forward page="Index.jsp"/>
    <%
 	}
 	session.setAttribute("loggedIn", null);					
 	session.setAttribute("searchBook", null);
	%>
<h2>Goodbye, terminated session!</h2>

</body>
</html>