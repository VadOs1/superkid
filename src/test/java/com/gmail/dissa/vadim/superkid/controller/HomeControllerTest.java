package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.config.RootConfig;
import com.gmail.dissa.vadim.superkid.config.WebConfig;
import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.exception.BadRequestException;
import com.gmail.dissa.vadim.superkid.service.CRMService;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import com.gmail.dissa.vadim.superkid.service.SendToJmsService;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class HomeControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private HomeController homeController;
    private ProductService productService;
    private CRMService crmService;
    private SendToJmsService sendToJmsService;
    private ShoppingCartService shoppingCartService;

    @Before
    public void setup() {
        productService = mock(ProductService.class);
        crmService = mock(CRMService.class);
        sendToJmsService = mock(SendToJmsService.class);
        shoppingCartService = mock(ShoppingCartService.class);
        homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);

        when(productService.getProducts()).thenReturn(new HashSet<Product>());
        when(shoppingCartService.getProducts()).thenReturn(new ArrayList<Product>());
        when(productService.getProductsByArticle("300101")).thenReturn(new ArrayList<>());
        when(shoppingCartService.getAmountOfGoodsInCart()).thenReturn(100.0);

        when(productService.findByProductInfoArticleAndProductSizeId("300101", 1)).thenReturn(mock(Product.class));
        when(shoppingCartService.addProduct(any(Product.class))).thenReturn(new Product());

        when(crmService.saveOrder("name", "email", "phone")).thenReturn(mock(Order.class));
        when(sendToJmsService.sendMailAlert(any(Order.class))).thenReturn(new Order());

        this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(productService, crmService, sendToJmsService, shoppingCartService)).build();
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInHomeMethod() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("products", new HashSet<Product>()))
                .andExpect(model().attribute("productsInCart", new ArrayList<Product>()))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void testModelAndViewInHomeMethod() throws Exception {
        ModelAndView modelAndView = homeController.home(new ModelAndView());
        assertEquals("home", modelAndView.getViewName());
        assertEquals(new HashSet<Product>(), modelAndView.getModel().get("products"));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInProductMethod() throws Exception {
        mockMvc.perform(get("/products/300101")).andExpect(status().isOk())
                .andExpect(view().name("product"))
                .andExpect(model().attribute("productsByArticle", new ArrayList<>()))
                .andExpect(model().attribute("productsInCart", new ArrayList<Product>()))
                .andExpect(model().attribute("featuredProducts", new HashSet<Product>()))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void testModelAndViewInProductMethod() throws Exception {
        HomeController homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);
        ModelAndView modelAndView = homeController.product("300101", new ModelAndView());
        assertEquals("product", modelAndView.getViewName());
        assertEquals(new ArrayList<>(), modelAndView.getModel().get("productsByArticle"));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals(new HashSet<Product>(), modelAndView.getModel().get("featuredProducts"));
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInCartMethod() throws Exception {
        mockMvc.perform(get("/cart/")).andExpect(status().isOk())
                .andExpect(view().name("cart"))
                .andExpect(model().attribute("productsInCartAmount", 100.0))
                .andExpect(model().attribute("productsInCart", new ArrayList<Product>()))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void testModelAndViewInCartMethod() throws Exception {
        HomeController homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);
        ModelAndView modelAndView = homeController.cart(new ModelAndView());
        assertEquals("cart", modelAndView.getViewName());
        assertEquals(100.0, modelAndView.getModel().get("productsInCartAmount"));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInCartNewMethod() throws Exception {
        mockMvc.perform(get("/cart/new/?article=300101&size=1")).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/cart/"))
                .andExpect(model().attributeExists("product"))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void testModelAndViewInCartNewMethod() throws Exception {
        HomeController homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);
        ModelAndView modelAndView = homeController.cartNew("300101", 1, new ModelAndView());
        assertNotNull(modelAndView.getModel().get("product"));
        assertEquals("redirect:/cart/", modelAndView.getViewName());
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInClearCartMethod() throws Exception {
        mockMvc.perform(get("/cart/clear/")).andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/cart/"))
                .andExpect(model().attribute("products", new ArrayList<Product>()))
                .andExpect(model().hasNoErrors());
    }

    @Test
    public void testModelAndViewInClearCartMethod() throws Exception {
        HomeController homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);
        ModelAndView modelAndView = homeController.cartClear(new ModelAndView());
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("products"));
        assertEquals("redirect:/cart/", modelAndView.getViewName());
    }

    @Test
    public void testResponseCodeAndViewNameAndModelAttributesInCheckoutMethod() throws Exception {
        mockMvc.perform(post("/checkout/").param("name", "name").param("email", "email").param("phone", "phone"))
                .andExpect(status().isOk())
                .andExpect(view().name("checkout"))
                .andExpect(model().attributeExists("order"))
                .andExpect(model().attribute("productsInCart", new ArrayList<Product>()))
                .andExpect(model().attribute("productsInCartAmount", 100.0))
                .andExpect(model().hasNoErrors());
    }


    @Test
    public void testModelAndViewInCheckoutMethod() throws Exception {
        HomeController homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);
        ModelAndView modelAndView = homeController.checkout("name", "email", "phonr", new ModelAndView());
        assertNotNull(modelAndView.getModel().get("order"));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals(100.0, modelAndView.getModel().get("productsInCartAmount"));
        assertEquals("checkout", modelAndView.getViewName());
    }

    @Test(expected = BadRequestException.class)
    public void testBadRequestInCheckoutGetMethod() {
        HomeController homeController = new HomeController(productService, crmService, sendToJmsService, shoppingCartService);
        homeController.checkoutGet();
    }
}
