package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ShoppingCartServiceImplTest {
    private ShoppingCartService shoppingCartService;
    private ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(mock(Product.class));
        shoppingCart.addProduct(mock(Product.class));
        shoppingCart.addProduct(mock(Product.class));
        shoppingCartService = new ShoppingCartServiceImpl(shoppingCart);
    }

    @Test
    public void testGetAmountOfGoodsInCart() {
        assertEquals((int) shoppingCartService.getAmountOfGoodsInCart(), (int) shoppingCart.getAmountOfGoodsInCart());
    }

    @Test
    public void testRemoveProducts() {
        shoppingCartService.removeProducts();
        assertEquals(shoppingCart.getProducts().size(), 0);
    }

    @Test
    public void testAddProduct() {
        shoppingCartService.addProduct(mock(Product.class));
        assertEquals(shoppingCart.getProducts().size(), 4);
    }

    @Test
    public void testGetShoppingCart() {
        assertSame(shoppingCartService.getShoppingCart(), shoppingCart);
    }
}
