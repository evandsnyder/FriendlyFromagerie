package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import domain.LoginBean;
import domain.UserBean;
import managers.LoginManager;

public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = -1511760609397773472L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		LoginBean loginBean = new LoginBean(request.getParameter("username"), request.getParameter("password"));
		
		UserBean user = (new LoginManager()).authenticate(loginBean);
		String forwardDestination = "/error";
		
		
		if(user != null) {
			request.getSession().setAttribute("user", user);
			forwardDestination = "/home";
		} else {
			request.setAttribute("error-msg", "The credentials you entered were invalid");
		}
		
		getServletContext().getRequestDispatcher(forwardDestination).forward(request, response);
	}
}
