package presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = -3151853063051708289L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>Error</title></head><body>");
		
		out.printf("<h1 style=\"color:red;\"> Sorry, something went wrong: %s</h1>", request.getAttribute("error-msg"));
		
		out.print("</body></html>");
	}

}
