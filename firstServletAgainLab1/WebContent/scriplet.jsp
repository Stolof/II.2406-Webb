<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scriplet jsp</title>
</head>
<body>

<h1> JSP scriplet the date: 

<% out.print( new java.util.Date()); %>

</h1>

<h1> The server IP address: 

<% out.print( request.getRemoteHost() ); %>

</h1>
</body>
</html>