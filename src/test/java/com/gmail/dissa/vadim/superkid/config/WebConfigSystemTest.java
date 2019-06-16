package com.gmail.dissa.vadim.superkid.config;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import com.gmail.dissa.vadim.superkid.aspect.ControllerExceptionAspect;
import com.gmail.dissa.vadim.superkid.controller.AdviceController;
import com.gmail.dissa.vadim.superkid.controller.HomeController;
import com.gmail.dissa.vadim.superkid.controller.SeoController;
import com.gmail.dissa.vadim.superkid.service.CRMService;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import com.gmail.dissa.vadim.superkid.service.SendMailService;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertNotNull;

public class WebConfigSystemTest extends AbstractSuperkidSystemTest {
    @Autowired
    ControllerExceptionAspect controllerExceptionAspect;
    @Autowired
    HomeController homeController;
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
    public void controllerExceptionAspectShouldNotBeNull() {
        assertNotNull("ControllerExceptionAspect should not be null", controllerExceptionAspect);
    }

    @Test
    public void homeControllerShouldNotBeNull() {
        assertNotNull("HomeController should not be null", homeController);
    }

    @Test
    public void seoControllerShouldNotBeNull() {
        assertNotNull("SeoController should not be null", seoController);
    }

    @Test
    public void adviceControllerShouldNotBeNull() {
        assertNotNull("AdviceController should not be null", adviceController);
    }

    @Test
    public void crmServiceShouldNotBeNull() {
        assertNotNull("CRMService should not be null", crmService);
    }

    @Test
    public void productServiceShouldNotBeNull() {
        assertNotNull("ProductService should not be null", productService);
    }

    @Test
    public void sendMailServiceShouldNotBeNull() {
        assertNotNull("SendMailService should not be null", sendMailService);
    }

    @Test
    public void shoppingCartServiceShouldNotBeNull() {
        assertNotNull("ShoppingCartService should not be null", shoppingCartService);
    }
}
