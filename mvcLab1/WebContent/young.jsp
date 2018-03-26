<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Young display</title>
</head>
<body>

<jsp:useBean id="theBean" scope="request" type="lab.mvc.model.Person"/>

<h1>Bean properties for a young person: </h1>
<jsp:getProperty property="firstName" name="theBean"/>
<jsp:getProperty property="lastName" name="theBean"/>
<jsp:getProperty property="birthDay" name="theBean"/>
<jsp:getProperty property="sex" name="theBean"/>

</body>
</html>