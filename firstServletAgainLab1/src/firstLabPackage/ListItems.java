package firstLabPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListItems
 */
@WebServlet("/ListItems")
public class ListItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object list;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		HttpSession session=request.getSession(true);			// create session
		
		String item = request.getParameter("newItem");
		String itemKey = new String("item");
		ArrayList<String> list = new ArrayList<String>(); 		// Make an array
		
		session.setAttribute(itemKey, item);						// add Item to session
		//list.add((String) session.getAttribute("myArray"));
		list.add((String) session.getAttribute(itemKey));			// add Item to the list
		session.setAttribute("myArray", list);					// Try to add the item to the list
		writer.println(list);									// Print list
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
