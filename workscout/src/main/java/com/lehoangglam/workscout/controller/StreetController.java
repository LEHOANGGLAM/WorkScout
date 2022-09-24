package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.Category;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.entities.Street;
import com.lehoangglam.workscout.entities.UserAccount;
import com.lehoangglam.workscout.exception.ResourceNotFoundException;
import com.lehoangglam.workscout.repository.CategoryRepository;
import com.lehoangglam.workscout.repository.CompanyRepository;
import com.lehoangglam.workscout.repository.StreetRepository;
import com.lehoangglam.workscout.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StreetController {
    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/streets")
    public List<Street> getAllCategories(){
        return streetRepository.findAll();
    }

    @GetMapping("/streets/user/{id}")
    public Street getHeadquarters(@PathVariable Integer id){
        //UserAccount u = ;
        return streetRepository.findByUserId(userAccountRepository.findById(id));
    }

    @GetMapping("/streets/company/{id}")
    public List<Street> getLocationByCompanyId(@PathVariable Integer id){
        //UserAccount u = ;
        return streetRepository.findByCompanyId(companyRepository.findById(id));
    }
}