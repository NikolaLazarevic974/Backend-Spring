package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_article")
@Data
public class CartArticle {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private String status;
}
