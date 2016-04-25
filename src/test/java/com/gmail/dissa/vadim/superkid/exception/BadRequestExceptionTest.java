package com.gmail.dissa.vadim.superkid.exception;

import com.gmail.dissa.vadim.superkid.config.RootConfig;
import com.gmail.dissa.vadim.superkid.config.WebConfig;
import com.gmail.dissa.vadim.superkid.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class BadRequestExceptionTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test(expected = BadRequestException.class)
    public void testBadRequestException() {
        HomeController homeController = (HomeController)applicationContext.getAutowireCapableBeanFactory().getBean("homeController");
        homeController.product("00000", new ModelAndView());
    }
}
