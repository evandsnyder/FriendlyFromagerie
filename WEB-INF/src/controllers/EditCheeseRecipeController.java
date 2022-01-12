package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import domain.CheeseRecipeBean;
import managers.EditCheeseRecipeManager;

public class EditCheeseRecipeController extends HttpServlet {
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
		
		String forwardDestination = "/error";

		if ((new EditCheeseRecipeManager()).isValidRecipe(recipe)) {
			request.setAttribute("recipe", recipe);
			forwardDestination = "/recipeSaved";
		} else {
			request.setAttribute("error-msg", "The data you entered was invalid, and we couldn't save your recipe :(");
		}
		
		getServletContext().getRequestDispatcher(forwardDestination).forward(request, response);
	}
}
