package com.friendlygeek.friendlyfromagerie.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendlygeek.friendlyfromagerie.domain.CheeseRecipe;
import com.friendlygeek.friendlyfromagerie.managers.CheeseRecipeManager;

@Controller
public class CheeseRecipeController extends BaseController {

	@GetMapping("/cheese")
	public ModelAndView getCheeseRecipes(HttpSession session, Model model) {
		if (!isLoggedIn(session)) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView mav = new ModelAndView("cheeseview");
		mav.addObject("recipe", model.getAttribute("recipe"));
		
		return mav;
	}

	@GetMapping("/cheese/edit")
	public ModelAndView getEditRecipe(HttpSession session, Model model) {
		if (!isLoggedIn(session)) {
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("editcheese");
	}

	@PostMapping("/cheese/edit")
	public ModelAndView saveRecipe(@ModelAttribute(name="recipeForm") CheeseRecipe recipe, HttpSession session, Model model) {
		if (!isLoggedIn(session)) {
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView result = new ModelAndView();
		result.setViewName("/cheese/edit");
		
		if((new CheeseRecipeManager()).isValidRecipe(recipe)) {
			result.setViewName("redirect:/cheese");
			result.addObject("recipe", recipe);
		}
		
		return result;
	}
}
