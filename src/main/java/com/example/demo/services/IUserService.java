package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import io.jsonwebtoken.Jwt;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserModel> findAll();
    UserPageModel findAll(PageRequest pageRequest);
    UserModel create(UserModel model);
    UserModel update(UserModel model);
    void delete(UserModel model);
    UserModel getCurrentUser();

    UserModel updateSelf(UserModel model);
    void deleteSelf(UserModel model);

}
