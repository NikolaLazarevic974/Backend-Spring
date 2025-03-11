package com.example.demo.repositories;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);


    //@Query(nativeQuery = true, value = "SELECT * FROM user WHERE first_name Like (%:first_name%)")
    //List<User> findByFirstName(@Param("firstName") String first_name);


}
