package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_sizes")
public class ProductSize {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "size")
    private String size;
}
