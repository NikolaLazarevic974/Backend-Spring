package com.example.demo.mappers;

import com.example.demo.entities.Review;
import com.example.demo.models.ReviewModel;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {
    public static ReviewModel toModel(Review entity){
        return ReviewModel.builder().reviewText(entity.getReviewText()).user((entity.getUser().getUsername())).build();
    }

    public static List<ReviewModel> toModelList(List<Review> entities){
        var list = new ArrayList<ReviewModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }
}
