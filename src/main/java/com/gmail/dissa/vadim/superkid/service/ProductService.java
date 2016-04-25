package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;

import java.util.List;
import java.util.Set;

public interface ProductService {

    public Set<Product> getProducts();

    public List<Product> getProductsByArticle(String article);

    public Product findByProductInfoArticleAndProductSizeId(String article, long sizeId);

    public ProductInfo findProductInfoByArticle(String article);

    public List<ProductInfo> getAllProductInfo();
}
