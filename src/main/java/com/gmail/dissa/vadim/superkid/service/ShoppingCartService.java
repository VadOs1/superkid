package com.gmail.dissa.vadim.superkid.service;


import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    public List<Product> getProducts();
    public double getAmountOfGoodsInCart();
    public List<Product> removeProducts();
    public Product addProduct(Product product);
    public ShoppingCart getShoppingCart();
}
