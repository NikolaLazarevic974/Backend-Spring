package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.mappers.UserProductMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductModel;
import com.example.demo.repositories.IUserProductRepository;
import com.example.demo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IUserProductRepository userProductRepository;

    @Override
    public List<UserModel> findAll() {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @Override
    public UserPageModel findAll(PageRequest pageRequest) {
        return UserMapper.toModelPagedList(userRepository.findAll(pageRequest));
    }

    @Override
    public UserModel create(UserModel model) {

        var entity = UserMapper.toEntity(model);
        var result = userRepository.save(entity);
        var returnedUser = UserMapper.toModel(result);
        return returnedUser;

    }

    @Override
    public List<UserProductModel> findUserProductsList() {
        return UserProductMapper.toModelList(userProductRepository.findAll());
    }
}
