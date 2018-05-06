<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booking</title>
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
<h1>Booking!</h1>
<%@ page import ="login.service.Book" %>
<%
if(session.getAttribute("searchBook") != null){					    // If a search has been made, show option to reserve the book
%>
<p> You searched for: 
<jsp:useBean id="current" type="login.service.Book" scope="request"/><%= current.getName()%> The book is <p>	

 <% login.service.Reservation reservation = new login.service.Reservation();
 		String status = "Not Available";
 		
 		if(!current.isReserved()){									// only show the button if the book is available
 			status = "Available";
 			%>
 			<%= status %> 
 			<form action="ResServlet" method="post">
 			<input name="bookTag" value="<%=current.getName()%>" type="hidden">
			<input name="book" value="bookbtn" type="hidden"> Book 
			<input type="submit" value="Reserve!">
			</form>	
 		<% } else {%> <%= status %>								
	<% 
 		}
 		
} 
	%>


<form method="post" action="ResServlet">
	Search for book:
	<input type="text" name="tag" id="tags">
	<input type="submit" value="Search">
</form>

<form action="ResServlet" method="post">
	<input name="back" value="backbtn" type="hidden"> Back
	<input type="submit" value="Back">
</form>

<form action="AuthServlet" method="post">
	<input name="logout" value="logoutbtn" type="hidden"> Logout:
	<input type="submit" value="Log out">
</form>


</body>
</html>