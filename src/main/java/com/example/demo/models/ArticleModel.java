package com.example.demo.models;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ArticleModel {
    private Integer id;
    private String name;
    private String type;
    private String manufacturer;
    private Float price;
    private String image;
    private List<String> sizes;
    private List<ReviewModel> reviews;
}
