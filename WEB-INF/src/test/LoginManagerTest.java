package test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.LoginBean;
import managers.LoginManager;

public class LoginManagerTest {

	@Test
	public void testValidLogin() {
		LoginBean login = new LoginBean("admin", "password");
		assertNotNull("Authentication failed", (new LoginManager()).authenticate(login));
	}
	
	@Test
	public void testInvalidLogin() {
		LoginBean login = new LoginBean("admin", "");
		assertNull("Authentication should not have succeeded", (new LoginManager()).authenticate(login));
	}

}
