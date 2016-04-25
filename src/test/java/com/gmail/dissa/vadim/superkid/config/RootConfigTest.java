package com.gmail.dissa.vadim.superkid.config;

import com.gmail.dissa.vadim.superkid.domain.ShoppingCart;
import com.gmail.dissa.vadim.superkid.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;

@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RootConfigTest {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ShoppingCart shoppingCart;


    @Test
    public void clientRepositoryShouldNotBeNull() {
        assertNotNull("ClientRepository should not be null",clientRepository);
    }

    @Test
    public void orderRepositoryShouldNotBeNull() {
        assertNotNull("OrderRepository should not be null",orderRepository);
    }

    @Test
    public void orderStatusRepositoryShouldNotBeNull() {
        assertNotNull("OrderStatusRepository should not be null",orderStatusRepository);
    }

    @Test
    public void productCategoryRepositoryShouldNotBeNull() {
        assertNotNull("ProductCategoryRepository should not be null",productCategoryRepository);
    }

    @Test
    public void productInfoRepositoryShouldNotBeNull() {
        assertNotNull("ProductInfoRepository should not be null",productInfoRepository);
    }

    @Test
    public void productRepositoryShouldNotBeNull() {
        assertNotNull("ProductRepository should not be null",productRepository);
    }

    @Test
    public void productSizeRepositoryShouldNotBeNull() {
        assertNotNull("ProductSizeRepository should not be null",productSizeRepository);
    }

    @Test
    public void salesRepositoryShouldNotBeNull() {
        assertNotNull("SalesRepository should not be null",salesRepository);
    }

    @Test
    public void shoppingCartShouldNotBeNull() {
        assertNotNull("ShoppingCart should not be null",shoppingCart);
    }
}