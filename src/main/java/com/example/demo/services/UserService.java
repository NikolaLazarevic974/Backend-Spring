package com.example.demo.services;

import com.example.demo.entities.Article;
import com.example.demo.entities.User;
import com.example.demo.exceptions.user.UserAlreadyExistsException;
import com.example.demo.exceptions.user.UserException;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.repositories.IArticleRepository;
import com.example.demo.repositories.IUserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final IArticleRepository articleRepository;


    public int getCurrentUserId() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Currently authenticated user not found in database"));
        return user.getId();  // Return the ID instead of the full UserModel
    }

    public UserModel getCurrentUser() {
        Integer id = getCurrentUserId();
        return UserMapper.toModel(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Currently authenticated user not found in database")));
    }



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

        var entity = UserMapper.toEntity(model, passwordEncoder);
        var result = userRepository.save(entity);
        return UserMapper.toModel(result);

    }

    @Override
    public UserModel update(UserModel model) {
        var existingUser = userRepository.findByEmail(model.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        var entity = UserMapper.toEntity(model, passwordEncoder);
        try {
            var result = userRepository.save(entity);
            return UserMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    public void delete(UserModel model) {
        var entity = userRepository.findById(model.getId()).orElseThrow(() -> new UserException("User Not Found"));
        userRepository.delete(entity);
    }

    public UserModel updateSelf(UserModel model) {
        model.setId(getCurrentUserId());
        return(update(model));
    }

    public void deleteSelf(UserModel model) {
        model.setId(getCurrentUserId());
        delete(model);
    }

}
