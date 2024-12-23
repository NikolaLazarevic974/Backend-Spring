package com.example.demo.repositories;

import com.example.demo.entities.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserProductRepository extends JpaRepository<UserProduct, Integer> {
}
