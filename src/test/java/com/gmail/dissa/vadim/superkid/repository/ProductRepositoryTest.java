package com.gmail.dissa.vadim.superkid.repository;

import com.gmail.dissa.vadim.superkid.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByProductInfoId() {
        List<Product> productList = productRepository.findByProductInfoId(1);
        assertEquals(productList.size(), 6);
        assertEquals((int) productList.get(0).getPrice(), 415);
        assertEquals((int) productList.get(1).getPrice(), 415);
    }

    @Test
    public void testFindByProductInfoArticleAndProductSizeId() {
        Product product = productRepository.findByProductInfoArticleAndProductSizeId("400101", 3);
        //TODO: fix test
        //assertEquals(product.getProductCategory().getId(), 2);
        //assertEquals(product.getProductInfo().getId(), 3);
        //assertEquals(product.getProductSize().getId(), 3);
        //assertEquals((int) product.getPrice(), 300);
        //assertEquals(product.getQuantity(), 30);
    }
}
