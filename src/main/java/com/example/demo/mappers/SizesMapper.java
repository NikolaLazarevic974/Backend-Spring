package com.example.demo.mappers;

import com.example.demo.entities.Sizes;
import com.example.demo.models.SizesModel;

import java.util.ArrayList;
import java.util.List;

public class SizesMapper {
    public static SizesModel toModel(Sizes entity){
        return SizesModel.builder().size(entity.getSize()).build();
    }

    public static List<String> toModelList(List<Sizes> entities){
        var list = new ArrayList<String>();
        for (var entity : entities) {
            list.add(entity.getSize());
        }
        return list;
    }
}
