package com.example.demo.models;

import com.example.demo.entities.Article;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserModel {
    private int id;
    private String address;
    @Email
    private String email;
    @NotBlank
    private String password;
    private List<ArticleModel> cartItems = new ArrayList<>();

}
