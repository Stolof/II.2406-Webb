package login.service;

import java.io.IOException;
import java.util.*;

public class Reservation {
	
	public static ArrayList<Book> availableBooks = new ArrayList<Book>(); 	// Array with available books
	
	Book book1 = new Book("book1");											 
	Book book2 = new Book("book2");
	Book book3 = new Book("book3");
	Book book4 = new Book("book4");
	
	
	public void fillBookings() {												// Function to fill the array with books
		book1.setReserved(false);
		book2.setReserved(false);
		book3.setReserved(false);
		book4.setReserved(false);
		availableBooks.add(book1);
		availableBooks.add(book2);
		availableBooks.add(book3);
		availableBooks.add(book4);
	}
	
	public Book searchBooking(String tag) throws IOException, ClassNotFoundException{ 	// Function search for book
		
		Book foundBook = null;						// If search tag is null, return null.
		if(tag == null) {
			return foundBook;
		}
		
		for(Book i:availableBooks) {					// search for book in available books array.
			if (tag.equals(i.getName())) {					
				return i;			
			}
		}
			
		return foundBook;
	}
	
	public void reservBook(Book book) throws IOException, ClassNotFoundException{				// Function to reserve a book
		for(Book i:availableBooks) {
			if (book.getName().equals(i.getName())) {
					if(!i.isReserved()) {
						i.setReserved(true);													// reserve book if it is not reserved.
						System.out.println("Book " + i.getName() + " IS " + i.isReserved());
					}
			}
		}
	}
	
	public boolean isFree(Book book) throws IOException, ClassNotFoundException{				// Check if book is reserved.
	for(Book i:availableBooks) {
			if (book.getName().equals(i.getName())) {
					if(!i.isReserved()) {												
						return true;														
					}
			}
		}
	return false;
	}

}
