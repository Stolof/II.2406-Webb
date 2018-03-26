<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login JSP</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> </script>
<!-- <script src="loginQuery.js" type="text/javascript"></script> -->
<script  type="text/javascript">
$(document).ready(function() {
	$('#loginButton').click(function(){
		
		var username = $('#username').val();
		var password = $('#password').val();
		
		$.ajax({
				type: 'POST',
				data: {username: username, password: password},
				url:	 'loginServlet', 									
				success: function(result){
					if(result == 1){										// if servlet return 1 show username
						$('#result1').html("Welcome " + username); 
					}
					else{												// else alert
						alert("Login " + username + " and password " + password + " are not correct ");
					}
				}
		});
	});
});

</script>
</head>
<body>

<form> <!-- method="post" action="loginServlet" name="loginForm" -->
	Login:
	<input type="text" id="username" ><br>
	Password:
	<input type="text" id="password"><br>
	<input type="button" value="Hello" id="loginButton"> 
	<!-- <input type="submit" id="loginButton" /><br> -->
	<span id="result1"></span>
</form>



</body>
</html>