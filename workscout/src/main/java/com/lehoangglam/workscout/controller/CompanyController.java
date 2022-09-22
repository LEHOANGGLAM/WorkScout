package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.exception.ResourceNotFoundException;
import com.lehoangglam.workscout.repository.CompanyRepository;
import com.lehoangglam.workscout.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer id){
        Company company = companyRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Company not exist with id: "+ id));
        return ResponseEntity.ok(company);
    }
//    @GetMapping("/companies/post-{id}")
//    public ResponseEntity<Company> getCompanyByPostId(@PathVariable Integer id){
//        Company company = companyRepository.findByPostId(id);
//        return ResponseEntity.ok(company);
//    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Integer id,@RequestBody Company companyNew){
        Company company = companyRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Company not exist with id: "+ id));

        company.setImage(companyNew.getImage());
        company.setAboutCompany(companyNew.getAboutCompany());
        company.setCompanyEmail(companyNew.getCompanyName());
        company.setCompanyName(companyNew.getCompanyName());
        company.setCompanySize(companyNew.getCompanySize());
        company.setCompanyWebsite(companyNew.getCompanyWebsite());


        Company updateCompany = companyRepository.save(company);
        return ResponseEntity.ok(updateCompany);
    }
}
