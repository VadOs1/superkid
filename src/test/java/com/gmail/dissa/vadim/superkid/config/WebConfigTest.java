package com.gmail.dissa.vadim.superkid.config;

import com.gmail.dissa.vadim.superkid.aspect.ControllerExceptionAspect;
import com.gmail.dissa.vadim.superkid.controller.*;
import com.gmail.dissa.vadim.superkid.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class WebConfigTest {
    @Autowired
    ControllerExceptionAspect controllerExceptionAspect;
    @Autowired
    HomeController homeController;
    @Autowired
    AdminController adminController;
    @Autowired
    RestController restController;
    @Autowired
    SeoController seoController;
    @Autowired
    AdviceController adviceController;
    @Autowired
    CRMService crmService;
    @Autowired
    ProductService productService;
    @Autowired
    SendMailService sendMailService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @Test
    public void controllerExceptionAspectShouldNotBeNull(){
        assertNotNull("ControllerExceptionAspect should not be null",controllerExceptionAspect);
    }

    @Test
    public void homeControllerShouldNotBeNull(){
        assertNotNull("HomeController should not be null",homeController);
    }

    @Test
    public void adminControllerShouldNotBeNull(){
        assertNotNull("AdminController should not be null",adminController);
    }

    @Test
    public void restControllerShouldNotBeNull(){
        assertNotNull("RestController should not be null",restController);
    }

    @Test
    public void seoControllerShouldNotBeNull(){
        assertNotNull("SeoController should not be null",seoController);
    }

    @Test
    public void adviceControllerShouldNotBeNull(){
        assertNotNull("AdviceController should not be null",adviceController);
    }

    @Test
    public void crmServiceShouldNotBeNull(){
        assertNotNull("CRMService should not be null",crmService);
    }

    @Test
    public void productServiceShouldNotBeNull(){
        assertNotNull("ProductService should not be null",productService);
    }

    @Test
    public void sendMailServiceShouldNotBeNull(){
        assertNotNull("SendMailService should not be null",sendMailService);
    }

    @Test
    public void shoppingCartServiceShouldNotBeNull(){
        assertNotNull("ShoppingCartService should not be null",shoppingCartService);
    }
}
