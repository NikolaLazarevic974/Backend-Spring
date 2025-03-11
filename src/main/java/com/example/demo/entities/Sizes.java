package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "article_sizes")
@Data
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "size")
    private String size;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonBackReference
    private Article article;
}
