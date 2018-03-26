package lab.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get parameters from form (index.html) 
		response.setContentType("text/html");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String birthDay = request.getParameter("birthDay");
		String sex = request.getParameter("sex");
		
		// Create instance of bean.
		Person person = new Person();
		
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setBirthDay(birthDay);
		person.setSex(sex);
		
		// Add the bean to the request
		request.setAttribute("theBean", person);

		// Send the user to the appropriate JSP file.
		String segments[] = birthDay.split("/");
		String year = segments[0];
		int ageSafety = Integer.parseInt(year);
		if (ageSafety > 1990) {
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/young.jsp");
			dispatcher.include(request, response);
		} else {
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/old.jsp");
			dispatcher.include(request, response);
		}
		
	}

}
