package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import domain.CheeseRecipeBean;

public class CreateEditCheeseRecipeController extends HttpServlet {
	private static final long serialVersionUID = 1613069843915894194L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		CheeseRecipeBean recipe = new CheeseRecipeBean();
		recipe.setCheeseType(request.getParameter("cheese-type"));
		recipe.setHardness(request.getParameter("hardness"));
		recipe.setMilkType(request.getParameter("milk-type"));
		recipe.setIngredients(request.getParameter("ingredients"));
		recipe.setWarmTheMilk(request.getParameter("warm-the-milk"));
		recipe.setCultureAndCoagulate(request.getParameter("culture-coagulate"));
		recipe.setLadleTheCurd(request.getParameter("ladle-curd"));
		recipe.setDrainTheCurd(request.getParameter("drain-curd"));
		recipe.setTargetFlavorAndTexture(request.getParameter("target-flavor-texture"));
		recipe.setStorage(request.getParameter("storage"));
		recipe.setNotes(request.getParameter("notes"));

		if (isValidRecipe(recipe)) {
			successPage(response, recipe);
		} else {
			failurePage(response);
		}
	}

	private boolean isValidRecipe(CheeseRecipeBean recipe) {
		return !recipe.getCheeseType().isEmpty() &&
				!recipe.getHardness().isEmpty() &&
				!recipe.getMilkType().isEmpty() &&
				!recipe.getIngredients().isEmpty() &&
				!recipe.getWarmTheMilk().isEmpty() &&
				!recipe.getCultureAndCoagulate().isEmpty() &&
				!recipe.getLadleTheCurd().isEmpty() &&
				!recipe.getDrainTheCurd().isEmpty() &&
				!recipe.getTargetFlavorAndTexture().isEmpty() &&
				!recipe.getStorage().isEmpty();
	}

	private void successPage(HttpServletResponse response, CheeseRecipeBean recipe) throws IOException {
		PrintWriter out = response.getWriter();
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
		out.printf("<br/>1. Warm  the Mil: <br/>%s", recipe.getWarmTheMilk());
		out.printf("<br/>2. Culture and Coagulate:<br/>%s", recipe.getCultureAndCoagulate());
		out.printf("<br/>3. Ladle the Curd:<br/>%s", recipe.getLadleTheCurd());
		out.printf("<br/>4. Drain the Curd:<br/>%s", recipe.getDrainTheCurd());
		out.printf("<br/>5. Target Flavor and Texture:<br/>%s", recipe.getTargetFlavorAndTexture());
		out.printf("<br/>6. Storage:<br/>%s", recipe.getStorage());
		out.printf("<br/>Additional Notes:<br/>%s", recipe.getNotes());

		out.print("</body>");
		out.print("</html>");

	}

	private void failurePage(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.print("<html>");
		out.print("<head><title>Cheese Creation Failed</title></head>");
		out.print("<body>");

		out.print("<h2 style=\"color:red;\">Error</h3>");
		out.print("<p>The data you entered was invalid, and we couldn't save your recipe :(</p>");

		out.print("</body>");
		out.print("</html>");
	}
}
