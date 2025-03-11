package com.example.demo.mappers;

import com.example.demo.entities.Article;
import com.example.demo.models.ArticleModel;
import com.example.demo.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleMapper {

    public static ArticleModel toModel(Article entity) {
        return ArticleModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .manufacturer(entity.getManufacturer())
                .price(entity.getPrice())
                .image(entity.getImage())
                .reviews(ReviewMapper.toModelList(entity.getReviews()))
                .sizes(SizesMapper.toModelList(entity.getSizes()))
                .build();
    }

    public static Article toEntity(ArticleModel model) {
        Article article = new Article();
        article.setId(model.getId());
        article.setName(model.getName());
        article.setType(model.getType());
        article.setManufacturer(model.getManufacturer());
        article.setPrice(model.getPrice());
        article.setImage(model.getImage());
        return article;
    }

    public static List<ArticleModel> toModelList(List<Article> entities) {
        var list = new ArrayList<ArticleModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }
}
