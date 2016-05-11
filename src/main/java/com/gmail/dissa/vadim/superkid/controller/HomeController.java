package com.gmail.dissa.vadim.superkid.controller;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.exception.BadRequestException;
import com.gmail.dissa.vadim.superkid.service.CRMService;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import com.gmail.dissa.vadim.superkid.service.SendToJmsService;
import com.gmail.dissa.vadim.superkid.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
@RequestMapping("/")
public class HomeController {

    // TODO: CAPTCHA TO CART -> CHECKOUT

    private ProductService productService;
    private CRMService crmService;
    private SendToJmsService sendToJmsService;
    // Session scope -> stores shopping cart for every visitor (domain package class)
    private ShoppingCartService shoppingCartService;

    @Autowired
    public HomeController(ProductService productService,
                          CRMService crmService,
                          SendToJmsService sendToJmsService,
                          ShoppingCartService shoppingCartService){
        this.productService = productService;
        this.crmService = crmService;
        this.sendToJmsService = sendToJmsService;
        this.shoppingCartService = shoppingCartService;
    };

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("products", productService.getProducts());
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/products/{article}")
    public ModelAndView product(@PathVariable("article") String article,
                                ModelAndView modelAndView) {
        modelAndView.addObject("productsByArticle", productService.getProductsByArticle(article));
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.addObject("featuredProducts", productService.getProducts());
        modelAndView.setViewName("product");
        return modelAndView;
    }

    @RequestMapping(value = "/cart/", method = RequestMethod.GET)
    public ModelAndView cart(ModelAndView modelAndView) {
        modelAndView.addObject("productsInCart", shoppingCartService.getProducts());
        modelAndView.addObject("productsInCartAmount", shoppingCartService.getAmountOfGoodsInCart());
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @RequestMapping(value = "/cart/new/", method = RequestMethod.GET)
    public ModelAndView cartNew(@RequestParam(value = "article") String article,
                                @RequestParam(value = "size") long size,
                                ModelAndView modelAndView) {
        modelAndView.addObject("product", shoppingCartService.addProduct(productService.findByProductInfoArticleAndProductSizeId(article, size)));
        modelAndView.setViewName("redirect:/cart/");
        return modelAndView;
    }

    @RequestMapping(value = "/cart/clear/", method = RequestMethod.GET)
    public ModelAndView cartClear(ModelAndView modelAndView) {
        modelAndView.addObject("products", shoppingCartService.removeProducts());
        modelAndView.setViewName("redirect:/cart/");
        return modelAndView;
    }

    @RequestMapping(value = "/checkout/", method = RequestMethod.POST)
    public ModelAndView checkout(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "phone") String phone,
                                 ModelAndView modelAndView) {
        modelAndView.addObject("order", sendToJmsService.sendMailAlert(crmService.saveOrder(name, email, phone)));
        modelAndView.addObject("productsInCart", new ArrayList<Product>(shoppingCartService.getProducts()));
        modelAndView.addObject("productsInCartAmount", shoppingCartService.getAmountOfGoodsInCart());
        modelAndView.setViewName("checkout");
        shoppingCartService.removeProducts();
        return modelAndView;
    }

    @RequestMapping(value = "/checkout/", method = RequestMethod.GET)
    public void checkoutGet() {
        throw new BadRequestException("GET method in checkout is not supported");
    }
}