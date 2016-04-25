package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ShoppingCartServiceImplTest {

    private ShoppingCartService shoppingCartService;
    private List<Product> products;
    private ShoppingCart shoppingCart;


    @Before
    public void setUp() {
        products = new ArrayList<>();
        products.add(mock(Product.class));
        products.add(mock(Product.class));
        products.add(mock(Product.class));
        shoppingCart = new ShoppingCart(products);
        shoppingCartService = new ShoppingCartServiceImpl(shoppingCart);
    }

    @Test
    public void testGetProducts() {
        assertSame(shoppingCartService.getProducts(), products);
    }

    @Test
    public void testGetAmountOfGoodsInCart() {
        assertEquals((int) shoppingCartService.getAmountOfGoodsInCart(), (int) shoppingCart.getAmountOfGoodsInCart());
    }

    @Test
    public void testRemoveProducts() {
        shoppingCartService.removeProducts();
        assertEquals(products.size(), 0);
    }

    @Test
    public void testAddProduct() {
        shoppingCartService.addProduct(mock(Product.class));
        assertEquals(products.size(), 4);
    }

    @Test
    public void testGetShoppingCart() {
        assertSame(shoppingCartService.getShoppingCart(), shoppingCart);
    }
}
