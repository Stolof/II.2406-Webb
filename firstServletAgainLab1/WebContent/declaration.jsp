<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Declaration jsp</title>
</head>
<body>

<%! 
private int numEntries = 10;
private int randomInt(int range) {
	return(1 + ((int)(Math.random() * range)));
	} 
%>
<h1>A random list from 1 to 100:</h1>

<ul>
<% 
for(int i=0; i<numEntries; i++) {
	out.println("<li>" + randomInt(100));
	}
%>
</ul>

</body>
</html>