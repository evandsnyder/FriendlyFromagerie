package com.friendlygeek.friendlyfromagerie.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public void internalServerError() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "An error occured on our end!");
		mav.setViewName("redirect:/error");
	}
}
