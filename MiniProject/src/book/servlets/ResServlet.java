package book.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.service.Book;
import login.service.Reservation;

/**
 * Servlet implementation class ResServlet
 */
@WebServlet("/ResServlet")
public class ResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		session.setAttribute("searchBook", null);			// reset Parameter, only show search result if search was pressed
		
		String searchTag = request.getParameter("tag");		// Get search tag
		String bookBtn = request.getParameter("book"); 		// Parameter for book button was pressed.
		String bookTag = request.getParameter("bookTag");		// Parameter for the last search
		String back = request.getParameter("back");			// Parameter for back button
		
		RequestDispatcher dispatcher = null;
		Reservation reservation = new Reservation();
		
		if(Reservation.availableBooks.isEmpty()) {						// if books not yet filled, fill the array.
			System.out.println("Filling books");
			reservation.fillBookings();
		}
		
		Book current = null;												// Search for a book and set in into the bean to possible display
		try {
			current = reservation.searchBooking(searchTag);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("current", current);						 // Save the found book in a bean
		
		if(session.getAttribute("loggedIn") == null && bookBtn != null ) { // If not logged in and tries to reserve a book
			System.out.println("YOU HAVE TO LOG IN TO MAKE A RESERVATION");
			dispatcher = getServletContext().getRequestDispatcher("/Index.jsp");
			dispatcher.include(request, response);
			return;
		} else if (session.getAttribute("loggedIn") == null){				// Console warning, can only search when not logged in
			System.out.println("YOU ARE NOT LOGGED IN BUT YOU CAN SEARCH");

		}
		

		try {
			
			if ( bookBtn != null ){										// Book button pressed
				
				current = reservation.searchBooking(bookTag);			// Search for booked stored from the last search
				reservation.reservBook(current); 						// reserve the book
				request.setAttribute("current", current);				// save to attribute to display in confirmation
				dispatcher = getServletContext().getRequestDispatcher("/confirmation.jsp");
			}
			
			else if ( back != null ) {									// back button pressed
				
				dispatcher = getServletContext().getRequestDispatcher("/books.jsp");
			}
			
			else if(searchTag != null){									// Search button pressed
				
				if(reservation.searchBooking(searchTag) != null) {		// Check if book is in the system
				session.setAttribute("searchBook", true);				
				} else {
					System.out.println("No book found by that name");
				}
				dispatcher = getServletContext().getRequestDispatcher("/books.jsp");
			}
			
			dispatcher.include(request, response);
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
