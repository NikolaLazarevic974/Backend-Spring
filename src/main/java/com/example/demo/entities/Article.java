package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "article")
@Data
public class Article {
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="manufacturer")
    private String manufacturer;
    @Column(name="price")
    private Float price;
    @Column(name="image")
    private String image;

    @OneToMany(mappedBy = "article")
    private List<Sizes> sizes;

    @OneToMany(mappedBy = "article")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "cartItems")
    @JsonBackReference
    private List<User> users;
}
