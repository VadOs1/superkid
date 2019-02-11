package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.repository.ProductInfoRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    private ProductService productService;
    private List<Product> productList;
    private ProductInfo productInfo;
    private Product product;

    @Before
    public void setUp() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductInfoRepository productInfoRepository = mock(ProductInfoRepository.class);
        productService = new ProductServiceImpl(productRepository,
                productInfoRepository);
        productList = new ArrayList<>();
        productInfo = new ProductInfo();
        productInfo.setId(1);
        product = new Product();
        List<ProductInfo> productInfoList = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(productList);
        when(productInfoRepository.findByArticle("300101")).thenReturn(productInfo);
        when(productRepository.findByProductInfoId(1)).thenReturn(productList);
        when(productRepository.findByProductInfoArticleAndProductSizeId("300101", 1)).thenReturn(product);
        when(productInfoRepository.findAll()).thenReturn(productInfoList);
    }

    @Test
    public void testGetProducts() {
        assertEquals(productService.getProducts(), new HashSet<>(productList));
    }

    @Test
    public void testGetProductByArticle() {
        List<Product> productsExpected = productService.getProductsByArticle("300101");
        assertEquals(productsExpected, productList);
    }

    @Test
    public void testFindByProductInfoArticleAndProductSizeId() {
        Product productExpected = productService.findByProductInfoArticleAndProductSizeId("300101", 1);
        assertEquals(productExpected, product);
    }

    @Test
    public void testFindProductInfoByArticle() {
        ProductInfo productInfoExpected = productService.findProductInfoByArticle("300101");
        assertEquals(productInfoExpected, productInfo);
    }

    @Test
    public void testGetAllProductInfo() {
        List<ProductInfo> productInfoListExpected = productService.getAllProductInfo();
        assertEquals(productInfoListExpected, productInfoListExpected);
    }
}
