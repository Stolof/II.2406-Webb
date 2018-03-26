<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My first bean</title>
</head>
<body>

<jsp:useBean id="PersonBean" scope="request" class="isep.lab1.bean.Person"/> <!--  Request from the html -->

<jsp:setProperty property="firstName" name="PersonBean"/>
<jsp:setProperty property="lastName"  name="PersonBean"/>
<jsp:setProperty property="date"  name="PersonBean"/>
<jsp:setProperty property="gender" name="PersonBean"/>

<h1> This is some Bean properties: </h1>
<jsp:getProperty property="firstName" name="PersonBean"/>
<jsp:getProperty property="lastName" name="PersonBean"/>
<jsp:getProperty property="date" name="PersonBean"/>
<jsp:getProperty property="gender" name="PersonBean"/>



</body>
</html>