package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class AdviceController {
    private final ShoppingCartService shoppingCartService;

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
        log.error(httpServletRequest.getRemoteAddr() + " : " + httpServletRequest.getRequestURL());
        log.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
