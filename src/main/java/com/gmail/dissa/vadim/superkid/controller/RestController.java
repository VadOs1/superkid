package com.gmail.dissa.vadim.superkid.controller;


import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    // REST CONTROLLER. JUST EXAMPLE -> NEVER USED IN THIS APP (DEMO PURPOSE)

    private ProductService productService;

    @Autowired
    public RestController(ProductService productService){this.productService = productService;}

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ProductInfo getProductInfo(@RequestParam(value = "article") String article) {
        return productService.findProductInfoByArticle(article);
    }
}
