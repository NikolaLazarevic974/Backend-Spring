package com.example.demo.mappers;

import com.example.demo.entities.UserProduct;
import com.example.demo.models.UserProductModel;

import java.util.ArrayList;
import java.util.List;

public class UserProductMapper {

    public static UserProductModel toModel(UserProduct entity){
        return UserProductModel.builder()
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .products(ProductMapper.toModelList(entity.getProduct())).build();
    }

    public static List<UserProductModel> toModelList(List<UserProduct> entities){
        var list = new ArrayList<UserProductModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

}
