package com.gmail.dissa.vadim.superkid.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProducts() {
        this.products.clear();
        return products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getAmountOfGoodsInCart() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
