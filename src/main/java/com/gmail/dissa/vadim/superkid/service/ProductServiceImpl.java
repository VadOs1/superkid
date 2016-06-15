package com.gmail.dissa.vadim.superkid.service;

import com.gmail.dissa.vadim.superkid.domain.Product;
import com.gmail.dissa.vadim.superkid.domain.ProductInfo;
import com.gmail.dissa.vadim.superkid.exception.BadRequestException;
import com.gmail.dissa.vadim.superkid.repository.ProductCategoryRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductInfoRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductRepository;
import com.gmail.dissa.vadim.superkid.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductInfoRepository productInfoRepository;
    private ProductCategoryRepository productCategoryRepository;
    private ProductSizeRepository productSizeRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductInfoRepository productInfoRepository, ProductCategoryRepository productCategoryRepository, ProductSizeRepository productSizeRepository){
        this.productRepository = productRepository;
        this.productInfoRepository = productInfoRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productSizeRepository = productSizeRepository;
    }

    @Override
    public Set<Product> getProducts() {
        Set<Product> products = new HashSet<Product>(productRepository.findAll());
        return products;
    }

    @Override
    public List<Product> getProductsByArticle(String article) throws BadRequestException {
        try {
            ProductInfo productInfo = productInfoRepository.findByArticle(article);
            List<Product> products = productRepository.findByProductInfoId(productInfo.getId());
            return products;
        }
        catch (Exception e){
            throw new BadRequestException(e.toString());
        }
    }

    @Override
    public Product findByProductInfoArticleAndProductSizeId(String article, long sizeId) throws BadRequestException {
            Product product = productRepository.findByProductInfoArticleAndProductSizeId(article, sizeId);
            if(product==null){throw new BadRequestException("Can't find product by article and size");}
            return product;
    }

    @Override
    public ProductInfo findProductInfoByArticle(String article) {
        ProductInfo productInfo = productInfoRepository.findByArticle(article);
        if(productInfo==null){throw new BadRequestException("Can't find product by article");}
        return productInfo;
    }

    @Override
    public List<ProductInfo> getAllProductInfo() {
        return productInfoRepository.findAll();
    }
}
