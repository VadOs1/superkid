package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sales {
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

    public Sales(Order order, Product product, int price) {
        this.order = order;
        this.product = product;
        this.price = price;
    }
}
