package domain;

public class LoginBean {
	private String username;
	private String password;
	
	public LoginBean() {}
	public LoginBean(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() { return this.username; }
	public String getPassword() { return this.password; }
	
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
}
