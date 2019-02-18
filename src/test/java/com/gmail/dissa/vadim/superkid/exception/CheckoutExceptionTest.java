package com.gmail.dissa.vadim.superkid.exception;

import com.gmail.dissa.vadim.superkid.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class CheckoutExceptionTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test(expected = SuperkidException.class)
    public void testCheckoutException() {
        HomeController homeController = (HomeController) applicationContext.getAutowireCapableBeanFactory().getBean("homeController");
        homeController.checkout(null, null, null, new ModelAndView());
    }
}