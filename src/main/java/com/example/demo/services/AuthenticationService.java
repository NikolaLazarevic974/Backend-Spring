package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.exceptions.user.UserAlreadyExistsException;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.LoginResponseModel;
import com.example.demo.models.LoginUserModel;
import com.example.demo.models.RegisterUserModel;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;



    public UserModel signup(RegisterUserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);
        var existingUser = userRepository.findByEmail(model.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }

        return UserMapper.toModel(userRepository.save(user));
    }

    public LoginResponseModel authenticate(LoginUserModel input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        var authenticatedUser = userRepository.findByEmail(input.getEmail()).orElseThrow();
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseModel loginResponse = new LoginResponseModel();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return loginResponse;
    }


}

