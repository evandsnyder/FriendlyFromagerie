package com.friendlygeek.friendlyfromagerie.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.friendlygeek.friendlyfromagerie.application.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendlygeek.friendlyfromagerie.domain.models.CheeseRecipe;
import com.friendlygeek.friendlyfromagerie.service.RecipeService;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Optional;

@Controller
public class CheeseRecipeController extends BaseController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping({"/cheese", "/cheese/{recipeId}"})
    public ModelAndView getCheeseRecipes(@PathVariable Integer recipeId, HttpServletRequest request, HttpServletResponse response, Model model) throws NoHandlerFoundException {
        if (!isLoggedIn(request.getSession())) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mav = new ModelAndView("cheeseview");

        if (recipeId != null) {
            Optional<CheeseRecipe> recipe = recipeService.getRecipe(recipeId);
            if (!recipe.isPresent()) {
                throw new ResourceNotFoundException();
            }

            mav.addObject("recipes", recipe.get());
        } else {
            mav.addObject("recipes", recipeService.getAllRecipes());
        }

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
    public ModelAndView saveRecipe(@ModelAttribute(name = "recipeForm") CheeseRecipe recipe, HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView result = new ModelAndView();
        result.setViewName("/cheese/edit");

        if ((new RecipeService()).isValidRecipe(recipe)) {
            result.setViewName("redirect:/cheese");
            result.addObject("recipe", recipe);
        }

        return result;
    }
}
