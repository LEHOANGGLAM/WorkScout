package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.New;
import com.lehoangglam.workscout.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class NewController {
    @Autowired
    private NewRepository newRepository;

    @GetMapping("/news")
    public List<New> getAllApplies(){
        return newRepository.findAll();
    }
}
