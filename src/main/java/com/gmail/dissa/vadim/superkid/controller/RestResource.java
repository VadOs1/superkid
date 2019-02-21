package com.gmail.dissa.vadim.superkid.controller;


import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestResource {
    private final ProductService productService;

    @Autowired
    public RestResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductInfo getProductInfo(@RequestParam(value = "article") String article) {
        return productService.findProductInfoByArticle(article);
    }
}
