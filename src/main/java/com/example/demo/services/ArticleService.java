package com.example.demo.services;

import com.example.demo.mappers.ArticleMapper;
import com.example.demo.models.ArticleModel;
import com.example.demo.repositories.IArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final IArticleRepository articleRepository;


    public List<ArticleModel> findAll() {
        return ArticleMapper.toModelList(articleRepository.findAll());
    }
}
