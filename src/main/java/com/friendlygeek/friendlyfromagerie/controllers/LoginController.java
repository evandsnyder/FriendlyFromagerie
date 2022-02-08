package com.friendlygeek.friendlyfromagerie.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendlygeek.friendlyfromagerie.domain.Login;
import com.friendlygeek.friendlyfromagerie.domain.User;
import com.friendlygeek.friendlyfromagerie.managers.LoginManager;

@Controller
public class LoginController extends BaseController {
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public ModelAndView postLoginPage(@ModelAttribute(name="loginForm") Login login, HttpSession session, Model model) {
		User user = (new LoginManager()).authenticate(login);
		
		if(user != null) {
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/dashboard");
		}
		
		model.addAttribute("error", "Invalid Credentials");
		
		return new ModelAndView("login");
	}
}
