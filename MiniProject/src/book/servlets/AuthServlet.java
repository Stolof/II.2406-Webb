package book.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.service.Authentication;



/**
 * Servlet implementation class AuthServlet
 */

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true); 					// Create session at servlet, check it in JSP!
		
		RequestDispatcher dispatcher = null;
		
		String login = request.getParameter("login"); 					// Info from index.jsp 
		String password = request.getParameter("password");
		String logout = request.getParameter("logout");
		
		Authentication authentication = new Authentication();
		
		if (logout != null && logout.equals("logoutbtn") ){								//logout button pressed
			dispatcher = getServletContext().getRequestDispatcher("/goodbye.jsp");	
		} 
		else if ( authentication.authenticate(login, password) ) {						// Call authentication function to log in.
			session.setAttribute("loggedIn", true);
			session.setAttribute("searchBook", null);
			dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
		} 
		else {
			dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
		}
		dispatcher.include(request, response);
		}
			
}
