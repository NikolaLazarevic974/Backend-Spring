package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.services.IUserService;
import io.jsonwebtoken.Jwt;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("admin/get-list")
    public List<UserModel> getList(){
        return userService.findAll();
    }

    @GetMapping("admin/get-page-list")
    public UserPageModel getPageList(Integer page, Integer size){
        return userService.findAll(PageRequest.of(page, size));
    }

    @PostMapping("admin/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
        return ResponseEntity.ok(userService.create(userModel));
    }

    @PostMapping("admin/update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
        return ResponseEntity.ok(userService.update(userModel));
    }

    @DeleteMapping("admin/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid UserModel userModel, BindingResult result) {
        userService.delete(userModel);
        return ResponseEntity.ok("Successfully deleted the user with id " + userModel.getId());
    }

    @GetMapping("get-current-user")
    public UserModel getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("update-self")
    public ResponseEntity<?> updateSelf(@RequestBody @Valid UserModel userModel, BindingResult result) {
        return ResponseEntity.ok(userService.updateSelf(userModel));
    }

    @DeleteMapping("delete-self")
    public ResponseEntity<?> deleteSelf(@RequestBody @Valid UserModel userModel, BindingResult result) {
        userService.deleteSelf(userModel);
        return ResponseEntity.ok("Successfully deleted the user with id " + userModel.getId());
    }




}
