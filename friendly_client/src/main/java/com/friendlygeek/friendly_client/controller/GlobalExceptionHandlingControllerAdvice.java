package com.friendlygeek.friendly_client.controller;

import com.friendlygeek.friendly_client.application.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView internalServerError(Exception e) {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "An error occured on our end!");
        mav.setViewName("error");
        return mav;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoHandlerFoundException.class, ResourceNotFoundException.class})
    public ModelAndView notFoundError(Exception e){
        e.printStackTrace();
        return new ModelAndView("404");
    }
}