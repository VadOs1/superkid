package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}