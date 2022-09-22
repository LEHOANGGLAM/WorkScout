package com.lehoangglam.workscout.controller;


import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.exception.ResourceNotFoundException;
import com.lehoangglam.workscout.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class JobPostController {
    @Autowired
    private JobPostRepository jobPostRepository;

    @GetMapping("/jobpost")
    public List<JobPost> getAllJobPosts(){
        return jobPostRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/jobpost/{id}")
    public ResponseEntity<JobPost> getJobDetail(@PathVariable Integer id){
        JobPost jobPost = jobPostRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("JobPost not exist with id: "+ id));
        return ResponseEntity.ok(jobPost);
    }



//    @GetMapping("/jobpost/page{pageNo}")
//    public List<JobPost> getAllJobPosts(@PathVariable(value = "pageNo") Integer pageNo) {
//
//        Sort sort = Sort.by("id").descending();
//
//        int pageSize = 8;
//        Pageable pageable = PageRequest.of(pageNo - 1, 8,sort);
//        Page<JobPost> page = this.jobPostRepository.findAll(pageable);
//        List<JobPost> listJobPosts = page.getContent();
//
//
//        return listJobPosts;
//    }
}
