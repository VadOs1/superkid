package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCart shoppingCart;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public List<Product> getProducts() {
        return shoppingCart.getProducts();
    }

    @Override
    public double getAmountOfGoodsInCart() {
        return shoppingCart.getAmountOfGoodsInCart();
    }

    @Override
    public List<Product> removeProducts() {
        return shoppingCart.removeProducts();
    }

    @Override
    public Product addProduct(Product product) {
        shoppingCart.addProduct(product);
        return product;
    }

    @Override
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
