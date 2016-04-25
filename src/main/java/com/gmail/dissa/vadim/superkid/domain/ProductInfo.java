package com.gmail.dissa.vadim.superkid.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_info")
public class ProductInfo implements Serializable {
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

    public ProductInfo() {

    }

    public ProductInfo(String name, String article, String photoLinkShort, String photoLinkLong) {
        this.name = name;
        this.article = article;
        this.photoLinkShort = photoLinkShort;
        this.photoLinkLong = photoLinkLong;
    }

    public ProductInfo(long id, String name, String article, String photoLinkShort, String photoLinkLong) {
        this.id = id;
        this.name = name;
        this.article = article;
        this.photoLinkShort = photoLinkShort;
        this.photoLinkLong = photoLinkLong;
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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPhotoLinkShort() {
        return photoLinkShort;
    }

    public void setPhotoLinkShort(String photoLinkShort) {
        this.photoLinkShort = photoLinkShort;
    }

    public String getPhotoLinkLong() {
        return photoLinkLong;
    }

    public void setPhotoLinkLong(String photoLinkLong) {
        this.photoLinkLong = photoLinkLong;
    }
}
