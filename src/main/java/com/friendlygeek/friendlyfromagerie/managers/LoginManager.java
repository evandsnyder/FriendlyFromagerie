package com.friendlygeek.friendlyfromagerie.managers;

import com.friendlygeek.friendlyfromagerie.domain.Login;
import com.friendlygeek.friendlyfromagerie.domain.User;

public class LoginManager {

	public User authenticate(Login login) {
		User user = null;
		if (login.getUsername().equals("admin") && login.getPassword().equals("adminpassword")) {
			user = new User();
			user.setFirstName("Super");
			user.setLastName("Admin");
			user.setUsername("admin");
		}

		return user;
	}
}
