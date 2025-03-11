package com.example.demo.controllers;


import com.example.demo.models.ArticleModel;
import com.example.demo.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addArticleToCart(@RequestParam Integer articleId) {
        try {
            cartService.addArticleToCart(articleId);
            return ResponseEntity.ok("Article added to cart successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeArticleFromCart(@RequestParam Integer articleId) {
        try {
            cartService.removeArticleFromCart(articleId);
            return ResponseEntity.ok("Article removed from cart successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("get-cart")
    public List<ArticleModel> getCart() {
        return cartService.getCart();
    }
}
