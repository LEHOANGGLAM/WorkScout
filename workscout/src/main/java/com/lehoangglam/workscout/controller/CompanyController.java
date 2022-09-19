package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.repository.CompanyRepository;
import com.lehoangglam.workscout.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public List<Company> gettAllCompanies(){
        return companyRepository.findAll();
    }
}
