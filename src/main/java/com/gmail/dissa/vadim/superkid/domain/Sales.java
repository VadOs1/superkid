package com.gmail.dissa.vadim.superkid.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sales")
public class Sales implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    Product product;
    @Column(name = "price")
    int price;  // so we can see actual sale price if we provide some discount or change product price to new amount

    public Sales(){

    }

    public Sales(Order order, Product product, int price) {
        this.order = order;
        this.product = product;
        this.price = price;
    }

    public Sales(long id, Order order, Product product, int price) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
