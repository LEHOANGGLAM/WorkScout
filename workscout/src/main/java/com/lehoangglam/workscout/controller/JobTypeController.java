package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.JobCategory;
import com.lehoangglam.workscout.entities.JobType;
import com.lehoangglam.workscout.repository.JobCategoryRepository;
import com.lehoangglam.workscout.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class JobTypeController {
    @Autowired
    private JobTypeRepository jobTypeRepository;

    @GetMapping("/jobtype")
    public List<JobType> getAllJobTypes(){
        return jobTypeRepository.findAll();
    }
}
