package presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CheeseRecipeBean;

public class RecipeSavedServlet extends HttpServlet {
	private static final long serialVersionUID = -5870695126622198261L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		CheeseRecipeBean recipe = (CheeseRecipeBean)request.getAttribute("recipe");
		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head><title>Cheese Saved</title></head>");
		out.print("<body>");

		out.print("<h2 style=\"color:green;\">Cheese Saved</h3>");
		out.print("<p>Here's what we saved:</p>");
		
		out.printf("Cheese Type:<br/>%s", recipe.getCheeseType());
		out.printf("<br/>Cheese Hardness:<br/>%s", recipe.getHardness());
		out.printf("<br/>Milk Type:<br/>%s", recipe.getMilkType());
		out.printf("<br/>Ingredients:<br/>%s", recipe.getIngredients());
		out.print("<br/>Instructions:<br/>");
		out.printf("<br/>1. Warm  the Milk: <br/>%s", recipe.getWarmTheMilk());
		out.printf("<br/>2. Culture and Coagulate:<br/>%s", recipe.getCultureAndCoagulate());
		out.printf("<br/>3. Ladle the Curd:<br/>%s", recipe.getLadleTheCurd());
		out.printf("<br/>4. Drain the Curd:<br/>%s", recipe.getDrainTheCurd());
		out.printf("<br/>5. Target Flavor and Texture:<br/>%s", recipe.getTargetFlavorAndTexture());
		out.printf("<br/>6. Storage:<br/>%s", recipe.getStorage());
		out.printf("<br/>Additional Notes:<br/>%s", recipe.getNotes());

		out.print("</body>");
		out.print("</html>");

	}
}
