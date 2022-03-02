package com.friendlygeek.friendly_client.controller;

import com.friendlygeek.friendly_client.dto.LoginRequest;
import com.friendlygeek.friendly_client.dto.RegisterRequest;
import com.friendlygeek.friendly_client.model.User;
import com.friendlygeek.friendly_client.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView postLoginPage(@ModelAttribute(name = "loginForm") LoginRequest loginRequest, HttpSession session, Model model) {
        if (loginRequest == null) {
            logger.error("Invalid Login Request");
            return new ModelAndView("error");
        }

        logger.info("Attempting login");
        User user = userService.authenticate(loginRequest);

        if (user != null) {
            logger.info("Login Successful");
            session.setAttribute("user", user);
            return new ModelAndView("redirect:/dashboard");
        }

        logger.info("Login Failed");
        model.addAttribute("error", "Invalid Credentials");

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(HttpSession session) {
        if (isLoggedIn(session)) {
            return new ModelAndView("redirect:/dashboard");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView postRegistration(@ModelAttribute(name = "registrationForm") RegisterRequest registerRequest, HttpSession session, Model model) {
        if (isLoggedIn(session)) {
            return new ModelAndView("redirect:/dashboard");
        }

        userService.register(registerRequest);

        return new ModelAndView("redirect:/login");
    }
}