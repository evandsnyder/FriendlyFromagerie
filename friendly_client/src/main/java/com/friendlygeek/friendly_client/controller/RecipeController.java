package com.friendlygeek.friendly_client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.friendlygeek.friendly_client.application.ResourceNotFoundException;
import com.friendlygeek.friendly_client.model.Recipe;
import com.friendlygeek.friendly_client.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class RecipeController extends BaseController {
    @Autowired
    private RecipeService recipeService;

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @GetMapping("/cheese/{recipeId}")
    public ModelAndView getCheeseRecipes(@PathVariable(required = false) String recipeId, HttpServletRequest request,
                                         HttpServletResponse response, Model model) throws NoHandlerFoundException {
        if (!isLoggedIn(request.getSession())) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mav = new ModelAndView("cheeseview");

        if (recipeId != null) {
            Recipe recipe = recipeService.getRecipe(recipeId);

            mav.addObject("recipe", recipe);
        } else {
            mav.addObject("recipes", recipeService.getAllRecipes());
        }

        return mav;
    }

    @GetMapping({"/cheese/edit" ,"/cheese/edit/{recipeId}"})
    public ModelAndView getEditRecipe(@PathVariable(required = false) String recipeId, HttpSession session,
                                      Model model) {
        if (!isLoggedIn(session)) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mav = new ModelAndView("editcheese");

        if (recipeId != null) {
            Recipe recipe = recipeService.getRecipe(recipeId);

            mav.addObject("recipe", recipe);
        }

        return mav;
    }

    @PostMapping({"/cheese/edit" ,"/cheese/edit/{recipeId}"})
    public ModelAndView saveRecipe(@PathVariable(required = false) String recipeId,
                                   @ModelAttribute(name = "recipeForm") Recipe recipe, HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView result = new ModelAndView();
        result.setViewName("redirect:/cheese/edit");

        if (recipeService.isValidRecipe(recipe)) {
            if(recipe.getId().isEmpty()) recipe.setId(null);
            recipe.setPublish(true);
            result.setViewName("redirect:/cheese/" + recipeService.saveRecipe(recipe));
        }

        return result;
    }
}
