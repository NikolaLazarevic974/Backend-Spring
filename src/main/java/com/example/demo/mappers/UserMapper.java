package com.example.demo.mappers;

import com.example.demo.entities.Article;
import com.example.demo.entities.User;
import com.example.demo.models.ArticleModel;
import com.example.demo.models.RegisterUserModel;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserModel toModel(User entity){
        return UserModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .cartItems(convertArticlesToModel(entity.getCartItems()))
                .build();
    }

    private static List<ArticleModel> convertArticlesToModel(List<Article> articles) {
        if (articles == null) {
            return new ArrayList<>();  // Return empty list if articles is null
        }
        List<ArticleModel> articleModels = new ArrayList<>();
        for (Article article : articles) {
            articleModels.add(ArticleMapper.toModel(article)); // Convert each article to ArticleModel
        }
        return articleModels;
    }


    public static User toEntity(UserModel model, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setId(model.getId());
        user.setEmail(model.getEmail());
        user.setAddress(model.getAddress());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder){
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    public static List<UserModel> toModelList(List<User> entities){
        var list = new ArrayList<UserModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static UserPageModel toModelPagedList(Page<User> pageEntity){
        return UserPageModel.builder()
                .users(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getNumberOfElements())
                .build();
    }

}
