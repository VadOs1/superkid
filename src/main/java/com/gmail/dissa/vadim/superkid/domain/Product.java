package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
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

    // TODO: refactoring required
    public Product(double price) {
        this.price = price;
    }

    // TODO: refactoring required
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductInfo().equals(product.getProductInfo());
    }

    // TODO: refactoring required
    @Override
    public int hashCode() {
        return getProductInfo().hashCode();
    }
}