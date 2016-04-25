package com.gmail.dissa.vadim.superkid.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_info_id")
    private ProductInfo productInfo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_size_id")
    private ProductSize productSize;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;

    public Product() {

    }

    public Product(ProductInfo productInfo, ProductCategory productCategory, ProductSize productSize, double price, int quantity) {
        this.productInfo = productInfo;
        this.productCategory = productCategory;
        this.productSize = productSize;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(long id, ProductInfo productInfo, ProductCategory productCategory, ProductSize productSize, double price, int quantity) {
        this.id = id;
        this.productInfo = productInfo;
        this.productCategory = productCategory;
        this.productSize = productSize;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(double price) {
    this.price = price;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductInfo().equals(product.getProductInfo());
    }

    @Override
    public int hashCode() {
        return getProductInfo().hashCode();
    }
}