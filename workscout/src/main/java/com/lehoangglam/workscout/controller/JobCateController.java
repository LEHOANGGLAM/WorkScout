package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.JobCategory;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.repository.JobCategoryRepository;
import com.lehoangglam.workscout.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class JobCateController {
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @GetMapping("/jobcate")
    public List<JobCategory> getAllJobPosts(){
        return jobCategoryRepository.findAll();
    }

}
