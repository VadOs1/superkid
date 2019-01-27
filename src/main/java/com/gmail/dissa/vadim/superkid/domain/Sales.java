package com.gmail.dissa.vadim.superkid.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sales")
public class Sales implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "price")
    private int price;  // so we can see actual sale price if we provide some discount or change product price to new amount

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
