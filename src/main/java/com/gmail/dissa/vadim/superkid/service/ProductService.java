package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Set<Product> getProducts();

    List<Product> getProductsByArticle(String article);

    Product findByProductInfoArticleAndProductSizeId(String article, long sizeId);

    ProductInfo findProductInfoByArticle(String article);

    List<ProductInfo> getAllProductInfo();
}
