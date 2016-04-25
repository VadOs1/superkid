package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.exception.BadRequestException;
import com.gmail.dissa.vadim.superkid.exception.CheckoutException;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdviceControllerTest {

    Logger logger;
    ShoppingCartService shoppingCartService;

    @Before
    public void setup() {
        logger = mock(Logger.class);
        shoppingCartService = mock(ShoppingCartService.class);
        when(shoppingCartService.getProducts()).thenReturn(new ArrayList<Product>());
    }

    @Test
    public void testModelAndViewInNoHandlerFoundExceptionMethod() throws Exception {
        AdviceController adviceController = new AdviceController(logger, shoppingCartService);
        ModelAndView modelAndView = adviceController.noHandlerFoundException(mock(NoHandlerFoundException.class), mock(HttpServletRequest.class));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals("404", modelAndView.getViewName());
    }

    @Test
    public void testModelAndViewInBadRequestExceptionMethod() throws Exception {
        AdviceController adviceController = new AdviceController(logger, shoppingCartService);
        ModelAndView modelAndView = adviceController.badRequestException(mock(BadRequestException.class), mock(HttpServletRequest.class));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals("error", modelAndView.getViewName());
    }

    @Test
    public void testModelAndViewInCheckoutExceptionMethod() throws Exception {
        AdviceController adviceController = new AdviceController(logger, shoppingCartService);
        ModelAndView modelAndView = adviceController.checkoutException(mock(CheckoutException.class), mock(HttpServletRequest.class));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals("error", modelAndView.getViewName());
    }
}
