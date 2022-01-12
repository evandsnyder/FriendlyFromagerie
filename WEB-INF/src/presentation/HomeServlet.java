package presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import domain.UserBean;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = -8587856574460779540L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		
		String title = "Home";
		
		out.printf("<html><head><title>%s</title></head><body>", title);
		
		out.printf("<h1> Hello %s </h1>", user.getUsername());
		
		out.print("</body></html>");
	}

}
