package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_statuses")
public class OrderStatus {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
}
