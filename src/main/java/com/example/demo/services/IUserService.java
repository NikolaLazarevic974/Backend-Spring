package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {

    List<UserModel> findAll();
    UserPageModel findAll(PageRequest pageRequest);
    UserModel create(UserModel model);
    List<UserProductModel> findUserProductsList();
}
