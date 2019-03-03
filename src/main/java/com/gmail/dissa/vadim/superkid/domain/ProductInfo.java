package com.gmail.dissa.vadim.superkid.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_info")
public class ProductInfo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "article")
    private String article;
    @Column(name = "photo_link_short")
    private String photoLinkShort;
    @Column(name = "photo_link_long")
    private String photoLinkLong;
}
