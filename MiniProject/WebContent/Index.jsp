<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main page</title>
</head>
<body>
<% session.setAttribute("searchBook", null);
	session.setAttribute("loggedIn", null);%>
<h1>Login to make a reservation</h1>

<form action="AuthServlet" method="post" >
 	Login:
	<input type="text" name="login" /><br>
	Password:
	<input type="password" name="password" /><br>
	<input type="submit" value="Log in" /> 
</form>

</body>
</html>