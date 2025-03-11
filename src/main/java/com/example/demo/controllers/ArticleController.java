package com.example.demo.controllers;


import com.example.demo.models.ArticleModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.ArticleService;
import com.example.demo.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("get-list")
    public List<ArticleModel> getList(){
        return articleService.findAll();
    }

    @GetMapping("get-list-with-details")
    public List<ArticleModel> getList2(){
        return articleService.findAll();
    }

}
