package com.gmail.dissa.vadim.superkid.exception;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import com.gmail.dissa.vadim.superkid.controller.HomeController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;

public class CheckoutExceptionTest extends AbstractSuperkidSystemTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test(expected = SuperkidException.class)
    public void testCheckoutException() {
        HomeController homeController = (HomeController) applicationContext.getAutowireCapableBeanFactory().getBean("homeController");
        homeController.checkout(null, null, null, new ModelAndView());
    }
}