package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("get-first-name")
    public String getFirstName(){
        return "Jhon";
    }

    @GetMapping("get-first-name-list")
    public List<String> getFirstNameList(){
        return List.of("Jhon", "Deere");
    }

    @PostMapping("create-user")
    public boolean createUser(String firstName, String lastName) {
        return true;
    }

    @PostMapping("create-user-body")
    public UserModel createUserBody(@RequestBody UserModel userModel) {
        userModel.setFirstName("Jhon");
        return userModel;
    }

}
