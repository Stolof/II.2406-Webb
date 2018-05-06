<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  var availableTags = [
	"book1",
	"book2",
	"book3",
	"book4"
  ];
  $( "#tags" ).autocomplete({
    source: availableTags
  });
});
</script>
</head>
<body>

<% 
 if(session.getAttribute("loggedIn") == null){				// if not loggedIn go to Index.jsp
	  %> <jsp:forward page="Index.jsp"/>
    <%
 	} 
	%>

<h1>Welcome! Search for a book:</h1>
<form method="post" action="ResServlet">
	Search for a book:
	<input type="text" name="tag" id="tags">
	<input type="submit" value="Search">
</form>

<form action="AuthServlet" method="post">
	<input id="logout" name="logout" value="logoutbtn" type="hidden"> logout:
	<input type="submit" value="Log out">
</form>



</body>
</html>