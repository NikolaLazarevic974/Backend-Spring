package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.mappers.UserProductMapper;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.models.UserProductModel;
import com.example.demo.repositories.IUserProductRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    /*
    private IUserRepository userRepository;
    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    */

    @GetMapping("get-list")
    public List<UserModel> getList(){
        return userService.findAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer page, Integer size){
        return userService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("get-user-product-list")
    public List<UserProductModel> getUserProductsList(){
        return userService.findUserProductsList();
    }


    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            //return ResponseEntity.badRequest().body(result);
            return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            //return ResponseEntity.badRequest().body(result);
            return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userService.update(userModel), HttpStatus.CREATED);
    }






}
