package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    //@Query(nativeQuery = true, value = "SELECT * FROM user WHERE first_name Like (%:first_name%)")
    //List<User> findByFirstName(@Param("firstName") String first_name);


}
