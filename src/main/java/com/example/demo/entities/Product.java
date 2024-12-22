package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="user_id")
    private String userId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="product_categories",
        joinColumns = @JoinColumn(name="product_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Category> categories;

}
