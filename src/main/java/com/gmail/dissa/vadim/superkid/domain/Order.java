package com.gmail.dissa.vadim.superkid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
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

    public Order() {

    }

    public Order(Date date, OrderStatus orderStatus, Client client, String shippingAddress, String shippingDetails, String comments) {
        this.date = date;
        this.orderStatus = orderStatus;
        this.client = client;
        this.shippingAddress = shippingAddress;
        this.shippingDetails = shippingDetails;
        this.comments = comments;
    }

    public Order(long id, Date date, OrderStatus orderStatus, Client client, String shippingAddress, String shippingDetails, String comments) {
        this.date = date;
        this.orderStatus = orderStatus;
        this.client = client;
        this.shippingAddress = shippingAddress;
        this.shippingDetails = shippingDetails;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public List<Sales> setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
        return salesList;
    }
}