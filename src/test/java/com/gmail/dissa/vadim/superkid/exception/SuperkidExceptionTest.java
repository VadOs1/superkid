package com.gmail.dissa.vadim.superkid.exception;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import com.gmail.dissa.vadim.superkid.controller.HomeController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;

public class SuperkidExceptionTest extends AbstractSuperkidSystemTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test(expected = SuperkidException.class)
    public void testBadRequestException() {
        HomeController homeController = (HomeController) applicationContext.getAutowireCapableBeanFactory().getBean("homeController");
        homeController.product("00000", new ModelAndView());
    }
}
