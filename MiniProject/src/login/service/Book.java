package login.service;

import java.io.Serializable;

public class Book implements Serializable{					// simple constructor for book with getters and setter
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private boolean reserved;
	
	public Book(String name) {				
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	
	

}
