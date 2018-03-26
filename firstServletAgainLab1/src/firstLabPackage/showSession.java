package firstLabPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class showSession
 */
@WebServlet("/showSession")
public class showSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		HttpSession s=request.getSession(true);									// Create session
		String welcome = "Welcome back";											// initial values
		Integer visitCount = 0;
		String visitCountKey = new String("visitCount");
		
		if (s.isNew()) {															//If new, Change welcome text
			welcome = "Welcome to my site";
		} else {																	// Else, increase the number of visits				
			visitCount = (Integer)s.getAttribute(visitCountKey);
			visitCount = visitCount + 1;
		}
		s.setAttribute(visitCountKey, visitCount);								// set the visit attribute 
		writer.println(welcome);													// Display the welcome text
		writer.println("Number of visits: " + s.getAttribute(visitCountKey));		// Display visit count
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
