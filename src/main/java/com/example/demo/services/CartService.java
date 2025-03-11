package com.example.demo.services;


import com.example.demo.entities.Article;
import com.example.demo.entities.User;
import com.example.demo.models.ArticleModel;
import com.example.demo.repositories.IArticleRepository;
import com.example.demo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final IUserRepository userRepository;
    private final IArticleRepository articleRepository;

    private final UserService userService;



    public void addArticleToCart(Integer articleId) {
        Integer userId = userService.getCurrentUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        user.getCartItems().add(article);
        userRepository.save(user);
    }

    public void removeArticleFromCart(Integer articleId) {
        Integer userId = userService.getCurrentUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        user.getCartItems().remove(article);
        userRepository.save(user);
    }

    public List<ArticleModel> getCart() {
        return userService.getCurrentUser().getCartItems();

    }

}
