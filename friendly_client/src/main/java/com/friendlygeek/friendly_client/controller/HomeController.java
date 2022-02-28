package com.friendlygeek.friendly_client.controller;

import javax.servlet.http.HttpSession;

import com.friendlygeek.friendly_client.model.Recipe;
import com.friendlygeek.friendly_client.model.User;
import com.friendlygeek.friendly_client.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        List<Recipe> recipes = recipeService.getAllRecipes();
        // ID hack
        recipes.forEach(recipe -> {
            String addr = recipe.getHref();
            String newId = addr.substring(addr.lastIndexOf('/')+1);
            recipe.setId(newId);
        });
        modelAndView.addObject("recipes", recipes);

        return modelAndView;
    }
}