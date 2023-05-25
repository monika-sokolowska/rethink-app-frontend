package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_article", columnDefinition = "INT")
    private Integer id;

    @Column(name = "title", columnDefinition = "TEXT")
    private String title;
    @Column(name = "text", columnDefinition = "LONGTEXT")
    private String text;

    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    public Integer getId_article() {
        return id;
    }

    public void setId_article(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
