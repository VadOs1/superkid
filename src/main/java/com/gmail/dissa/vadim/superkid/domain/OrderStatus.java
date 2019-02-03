package com.gmail.dissa.vadim.superkid.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_statuses")
public class OrderStatus implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    public OrderStatus() {

    }

    public OrderStatus(String name) {
        this.name = name;
    }

    public OrderStatus(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
