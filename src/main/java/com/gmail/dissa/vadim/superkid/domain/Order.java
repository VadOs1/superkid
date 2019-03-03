package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "date")
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_status")
    private OrderStatus orderStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "shipping_details")
    private String shippingDetails;
    @Column(name = "comments")
    private String comments;
    @Transient
    private List<Sales> salesList;

    public Order(Date date, OrderStatus orderStatus, Client client, String shippingAddress, String shippingDetails, String comments) {
        this.date = date;
        this.orderStatus = orderStatus;
        this.client = client;
        this.shippingAddress = shippingAddress;
        this.shippingDetails = shippingDetails;
        this.comments = comments;
    }

    // TODO: refactoring required
    public List<Sales> setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
        return salesList;
    }
}