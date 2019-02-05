package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
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
    private ShoppingCartService shoppingCartService;

    @Before
    public void setup() {
        shoppingCartService = mock(ShoppingCartService.class);
        when(shoppingCartService.getProducts()).thenReturn(new ArrayList<>());
    }

    @Test
    public void testModelAndViewInNoHandlerFoundExceptionMethod() {
        AdviceController adviceController = new AdviceController(shoppingCartService);
        ModelAndView modelAndView = adviceController.noHandlerFoundException(mock(NoHandlerFoundException.class), mock(HttpServletRequest.class));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals("404", modelAndView.getViewName());
    }

    @Test
    public void testModelAndViewInBadRequestExceptionMethod() {
        AdviceController adviceController = new AdviceController(shoppingCartService);
        ModelAndView modelAndView = adviceController.otherException(mock(SuperkidException.class), mock(HttpServletRequest.class));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals("error", modelAndView.getViewName());
    }

    @Test
    public void testModelAndViewInCheckoutExceptionMethod() {
        AdviceController adviceController = new AdviceController(shoppingCartService);
        ModelAndView modelAndView = adviceController.otherException(mock(SuperkidException.class), mock(HttpServletRequest.class));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals("error", modelAndView.getViewName());
    }
}
