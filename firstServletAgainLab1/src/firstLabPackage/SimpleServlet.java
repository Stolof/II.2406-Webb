package firstLabPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet( name="Simpleservlet",
			description = "Simple servlet for lab1", 
			urlPatterns = {"/FormServlet", "/Form_Servlet" , "/SimpleServlet"}) // Add URL alternatives
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String firstName = request.getParameter("firstName"); // Values from userform.html
		String lastName = request.getParameter("lastName");
		String date = request.getParameter("birthDate") ;
		String gender = request.getParameter("gender");
		
		// Print some html to display the values
		writer.println("<table style=\"width:100%\"> <tr> <th>Firstname</th> <th>Lastname</th> <th>Birth date</th><th>Gender</th></tr>"
				+ "<tr> <td>"  + firstName + "</td><td>"  + lastName + "</td><td>"  + date + "</td><td>"  + gender + "</td></tr></table><br>");
		writer.println("Welcome " + firstName + " " + lastName + " your birthdate is " + date + " you are a " + gender);
		writer.println("<form action='cookieServlet'>");						// To get to cookieservlet and display the cookies
		writer.println("<input type='submit' value='cookieShow'>");
		writer.println("</form>");
		
		Cookie cookieFirstName = new Cookie("firstNameCookie", firstName);	// Make cookies for question 1.2
		Cookie cookieLastName = new Cookie("lastNameCookie", lastName);
		Cookie cookieBirthDay = new Cookie("birthDayCookie", date);
		Cookie cookieGender = new Cookie("genderCookie", gender);

		cookieFirstName.setMaxAge(60*60*24*365);					//Cookie is stored for one year.
		response.addCookie(cookieFirstName);						//Add the cookies
		response.addCookie(cookieLastName);
		response.addCookie(cookieBirthDay);
		response.addCookie(cookieGender);		
	
	}
		
}
