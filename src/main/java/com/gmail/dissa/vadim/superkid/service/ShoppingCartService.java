package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<Product> getProducts();

    double getAmountOfGoodsInCart();

    List<Product> removeProducts();

    Product addProduct(Product product);

    ShoppingCart getShoppingCart();
}
