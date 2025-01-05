package com.example.demo.models;

import com.example.demo.validators.ContactNumberConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private int id;
    @NotNull
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @ContactNumberConstraint
    private String contactNumber;
    @NotBlank
    private String password;

}
