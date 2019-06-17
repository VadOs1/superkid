package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.exception.SuperkidException;
import com.gmail.dissa.vadim.superkid.repository.ProductInfoRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
// TODO: refactoring required
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductInfoRepository productInfoRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductInfoRepository productInfoRepository) {
        this.productRepository = productRepository;
        this.productInfoRepository = productInfoRepository;
    }

    @Override
    public Set<Product> getProducts() {
        return new HashSet<>(productRepository.findAll());
    }

    @Override
    public List<Product> getProductsByArticle(String article) throws SuperkidException {
        try {
            ProductInfo productInfo = productInfoRepository.findByArticle(article);
            return productRepository.findByProductInfoId(productInfo.getId());
        } catch (RuntimeException e) {
            throw new SuperkidException(e);
        }
    }

    @Override
    public Product findByProductInfoArticleAndProductSizeId(String article, long sizeId) throws SuperkidException {
        Product product = productRepository.findByProductInfoArticleAndProductSizeId(article, sizeId);
        if (product == null) {
            throw new SuperkidException("Can't find product by article and size");
        }
        return product;
    }

    @Override
    public ProductInfo findProductInfoByArticle(String article) {
        ProductInfo productInfo = productInfoRepository.findByArticle(article);
        if (productInfo == null) {
            throw new SuperkidException("Can't find product by article");
        }
        return productInfo;
    }

    @Override
    public List<ProductInfo> getAllProductInfo() {
        return productInfoRepository.findAll();
    }
}
