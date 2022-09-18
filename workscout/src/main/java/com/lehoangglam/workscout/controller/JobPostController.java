package com.lehoangglam.workscout.controller;


import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobPostController {
    @Autowired
    private JobPostRepository jobPostRepository;

    @GetMapping("/jobpost")
    public List<JobPost> getAllJobPosts(){
        return jobPostRepository.findAll();
    }
}
