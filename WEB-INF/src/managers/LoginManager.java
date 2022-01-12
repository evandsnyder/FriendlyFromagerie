package managers;

import domain.LoginBean;
import domain.UserBean;

public class LoginManager {
	public LoginManager() {}
	
	public UserBean authenticate(LoginBean login) {
		UserBean user = null;
		if(login.getUsername().equals("admin") && login.getPassword().equals("password")) {
			user = new UserBean();
			user.setUsername("admin");
			user.setFirstName("Super");
			user.setLastName("Administrator");
		}
		
		return user;
	}
}
