package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.repository.ProductCategoryRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductInfoRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductSizeRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private ProductService productService;
    private ProductRepository productRepository;
    private ProductInfoRepository productInfoRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductSizeRepository productSizeRepository;
    private List<Product> productList;
    private ProductInfo productInfo;
    private Product product;
    private List<ProductInfo> productInfoList;
    @Before
    public void setUp() {
        productRepository = mock(ProductRepository.class);
        productInfoRepository = mock(ProductInfoRepository.class);
        productCategoryRepository = mock(ProductCategoryRepository.class);
        productSizeRepository = mock(ProductSizeRepository.class);
        productService = new ProductServiceImpl(productRepository,
                productInfoRepository,
                productCategoryRepository,
                productSizeRepository);
        productList = new ArrayList<>();
        productInfo = new ProductInfo();
        productInfo.setId(1);
        product = new Product();
        productInfoList = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(productList);
        when(productInfoRepository.findByArticle("300101")).thenReturn(productInfo);
        when(productRepository.findByProductInfoId(1)).thenReturn(productList);
        when(productRepository.findByProductInfoArticleAndProductSizeId("300101", 1)).thenReturn(product);
        when(productInfoRepository.findAll()).thenReturn(productInfoList);
    }


    @Test
    public void testGetProducts() {
        Set<Product> productsActual = new HashSet<>(productList);
        Set<Product> productsExpected = new HashSet<>();
        productsExpected = productService.getProducts();
        assertEquals(productsExpected, productsActual);
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
    public void testfindProductInfoByArticle() {
        ProductInfo productInfoExpected = productService.findProductInfoByArticle("300101");
        assertEquals(productInfoExpected, productInfo);
    }

    @Test
    public void testGetAllProductInfo() {
        List<ProductInfo> productInfoListExpected = productService.getAllProductInfo();
        assertEquals(productInfoListExpected, productInfoListExpected);
    }

}
