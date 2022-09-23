package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.Category;
import com.lehoangglam.workscout.entities.JobPostActivity;
import com.lehoangglam.workscout.repository.CategoryRepository;
import com.lehoangglam.workscout.repository.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/cates")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}