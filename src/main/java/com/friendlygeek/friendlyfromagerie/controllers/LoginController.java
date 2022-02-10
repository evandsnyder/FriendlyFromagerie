package com.friendlygeek.friendlyfromagerie.controllers;

import javax.servlet.http.HttpSession;

import com.friendlygeek.friendlyfromagerie.domain.dtos.LoginRequest;
import com.friendlygeek.friendlyfromagerie.domain.dtos.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.friendlygeek.friendlyfromagerie.domain.models.User;
import com.friendlygeek.friendlyfromagerie.service.UserService;

@Controller
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView postLoginPage(@ModelAttribute(name = "loginForm") LoginRequest loginRequest, HttpSession session, Model model) {
        User user = userService.authenticate(loginRequest);

        if (user != null) {
            session.setAttribute("user", user);
            return new ModelAndView("redirect:/dashboard");
        }

        model.addAttribute("error", "Invalid Credentials");

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(HttpSession session) {
        if(isLoggedIn(session)){
            return new ModelAndView("redirect:/dashboard");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView postRegistration(@ModelAttribute(name = "registrationForm") RegisterRequest registerRequest, HttpSession session, Model model) {
        if(isLoggedIn(session)){
            return new ModelAndView("redirect:/dashboard");
        }

        userService.register(registerRequest);

        return new ModelAndView("redirect:/login");
    }
}
