package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="categories")
@Data
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<Product> products;
}
