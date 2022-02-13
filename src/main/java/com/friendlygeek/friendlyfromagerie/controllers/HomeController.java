package com.friendlygeek.friendlyfromagerie.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendlygeek.friendlyfromagerie.domain.models.User;
import com.friendlygeek.friendlyfromagerie.service.RecipeService;

@Controller
public class HomeController extends BaseController {
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/")
	public ModelAndView getIndex(HttpSession session, Model model) {
		if(!isLoggedIn(session)) {
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("redirect:/dashboard");
	}
	
	@GetMapping("/dashboard")
	public ModelAndView getDashboard(HttpSession session, Model model) {
		if(!isLoggedIn(session)) {
			return new ModelAndView("redirect:/login");
		}
		
		User user = (User)session.getAttribute("user");
		
		ModelAndView modelAndView = new ModelAndView("dashboard");
		modelAndView.addObject("firstName", user.getFirstName());
		modelAndView.addObject("recipes", recipeService.getAllRecipes());
		
		return modelAndView;
	}
}
