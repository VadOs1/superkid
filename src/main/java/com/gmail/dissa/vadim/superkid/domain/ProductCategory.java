package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}