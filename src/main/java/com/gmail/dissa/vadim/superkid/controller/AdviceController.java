package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final ShoppingCartService shoppingCartService;
    private final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @Autowired
    public AdviceController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView noHandlerFoundException(NoHandlerFoundException e, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("404");
        return modelAndView;
    }

    @ExceptionHandler({SuperkidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView otherException(Exception e, HttpServletRequest httpServletRequest) {
        logger.error(httpServletRequest.getRemoteAddr() + " : " + httpServletRequest.getRequestURL());
        logger.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
