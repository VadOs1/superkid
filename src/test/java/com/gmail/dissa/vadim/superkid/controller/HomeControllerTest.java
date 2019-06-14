package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.AbstractSuperkidSystemTest;
import com.gmail.dissa.vadim.superkid.domain.Order;
import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.service.CRMService;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import com.gmail.dissa.vadim.superkid.service.SendMailService;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
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

public class HomeControllerTest extends AbstractSuperkidSystemTest {
    private MockMvc mockMvc;
    private HomeController homeController;
    private ProductService productService;
    private CRMService crmService;
    private SendMailService sendMailService;
    private ShoppingCartService shoppingCartService;

    @Before
    public void setup() {
        productService = mock(ProductService.class);
        crmService = mock(CRMService.class);
        sendMailService = mock(SendMailService.class);
        shoppingCartService = mock(ShoppingCartService.class);
        homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);

        when(productService.getProducts()).thenReturn(new HashSet<>());
        when(shoppingCartService.getProducts()).thenReturn(new ArrayList<>());
        when(productService.getProductsByArticle("300101")).thenReturn(new ArrayList<>());
        when(shoppingCartService.getAmountOfGoodsInCart()).thenReturn(100.0);

        when(productService.findByProductInfoArticleAndProductSizeId("300101", 1)).thenReturn(mock(Product.class));
        when(shoppingCartService.addProduct(any(Product.class))).thenReturn(new Product());

        when(crmService.saveOrder("name", "email", "phone")).thenReturn(mock(Order.class));

        this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController(productService, crmService, shoppingCartService, sendMailService)).build();
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
    public void testModelAndViewInHomeMethod() {
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
    public void testModelAndViewInProductMethod() {
        HomeController homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);
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
    public void testModelAndViewInCartMethod() {
        HomeController homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);
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
    public void testModelAndViewInCartNewMethod() {
        HomeController homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);
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
    public void testModelAndViewInClearCartMethod() {
        HomeController homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);
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
    public void testModelAndViewInCheckoutMethod() {
        HomeController homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);
        ModelAndView modelAndView = homeController.checkout("name", "email", "phone", new ModelAndView());
        assertNotNull(modelAndView.getModel().get("order"));
        assertEquals(new ArrayList<Product>(), modelAndView.getModel().get("productsInCart"));
        assertEquals(100.0, modelAndView.getModel().get("productsInCartAmount"));
        assertEquals("checkout", modelAndView.getViewName());
    }

    @Test(expected = SuperkidException.class)
    public void testBadRequestInCheckoutGetMethod() {
        HomeController homeController = new HomeController(productService, crmService, shoppingCartService, sendMailService);
        homeController.checkoutGet();
    }
}
