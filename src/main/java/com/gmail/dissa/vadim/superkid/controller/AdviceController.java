package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.exception.BadRequestException;
import com.gmail.dissa.vadim.superkid.exception.CheckoutException;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AdviceController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    private Logger logger;

    public AdviceController(){
        logger = Logger.getLogger(AdviceController.class);
    }

    public AdviceController(Logger logger, ShoppingCartService shoppingCartService){
        this.logger = logger;
        this.shoppingCartService = shoppingCartService;
    }

    // Catching 404 NOT FOUND exception
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public ModelAndView noHandlerFoundException(NoHandlerFoundException e, HttpServletRequest httpServletRequest)   {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("404");
        return modelAndView;
    }

    // Catching BadRequestException
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ModelAndView badRequestException(BadRequestException e, HttpServletRequest httpServletRequest)   {
        logger.error(httpServletRequest.getRemoteAddr() + " : " + httpServletRequest.getRequestURL());
        logger.error(e.getMessage(),e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    // Catching CheckoutException
    @ExceptionHandler(CheckoutException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public ModelAndView checkoutException(CheckoutException e, HttpServletRequest httpServletRequest)   {
        logger.error(httpServletRequest.getRemoteAddr() + " : " + httpServletRequest.getRequestURL());
        logger.error(e.getMessage(),e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
