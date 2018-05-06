package login.service;

import java.util.*;

public class Authentication {
	
	public boolean authenticate(String login, String password) {
		
		ArrayList<User> users = new ArrayList<User>(); 				// Make array with three possible logins.
		
		User user1 = new User("olof","abc");
		User user2 = new User("user","pass");
		User user3 = new User("user2", "pass2");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);

		boolean valid = false;
		
		for(User i:users) {
			if (login.equals(i.getUsername()) && password.equals(i.getPassword())) {		// Check if entered name and pass
				valid = true;															// is the same as the arrays name and pass
			}
		}
		return valid;
	}
}
