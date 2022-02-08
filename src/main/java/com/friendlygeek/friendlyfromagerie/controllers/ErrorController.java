package com.friendlygeek.friendlyfromagerie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController extends BaseController {
	
	@GetMapping("/error")
	public String getError(Model model) {
		return "error";
	}
}
