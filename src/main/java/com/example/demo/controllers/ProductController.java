package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductRepository productRepository;

    @GetMapping("get-list")
    public List<Product> getList(){
        return productRepository.findAll();
    }

}
