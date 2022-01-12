package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import domain.LoginBean;

public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = -1511760609397773472L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		LoginBean loginBean = new LoginBean(request.getParameter("username"), request.getParameter("password"));
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Friendly Fromagerie Login</title></head>");
		out.print("<body>");
		
		
		if(authenticate(loginBean)) {
			out.print("<h1>Hello admin!</h1>");
		} else {
			out.print("<h1>Incorrect username or password</h1>");
		}
		
		out.print("</body>");
		out.print("</html>");
	}
	
	private boolean authenticate(LoginBean login) {
		return login.getUsername().equals("admin") && login.getPassword().equals("password");
	}
}
