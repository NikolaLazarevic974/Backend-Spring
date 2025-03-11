package com.example.demo.models;

import com.example.demo.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewModel {
    private String user;
    private String reviewText;
}
