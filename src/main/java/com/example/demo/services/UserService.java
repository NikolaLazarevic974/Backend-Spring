package com.example.demo.services;

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
        return UserMapper.toModel(result);

    }

    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntity(model);
        var result = userRepository.save(entity);
        return UserMapper.toModel(result);
    }

    @Override
    public List<UserProductModel> findUserProductsList() {
        return UserProductMapper.toModelList(userProductRepository.findAll());
    }
}
