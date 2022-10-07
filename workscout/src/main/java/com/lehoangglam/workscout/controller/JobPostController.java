package com.lehoangglam.workscout.controller;


import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.entities.JobType;
import com.lehoangglam.workscout.exception.ResourceNotFoundException;
import com.lehoangglam.workscout.payload.response.MessageResponse;
import com.lehoangglam.workscout.repository.CommentRepository;
import com.lehoangglam.workscout.repository.CompanyRepository;
import com.lehoangglam.workscout.repository.JobPostRepository;
import com.lehoangglam.workscout.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class JobPostController {
    @Autowired
    private JobPostRepository jobPostRepository;
    @Autowired
    private JobTypeRepository jobTypeRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/jobpost")
    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/jobpost/{id}")
    public ResponseEntity<JobPost> getJobDetail(@PathVariable Integer id) {
        JobPost jobPost = jobPostRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("JobPost not exist with id: " + id));
        return ResponseEntity.ok(jobPost);
    }

    @GetMapping("/jobpost/company/{id}")
    public List<JobPost> getJobPostsByCompanyId(@PathVariable Integer id) {
        return jobPostRepository.findByCompanyId(companyRepository.findById(id));
    }

    @PostMapping("/jobpost/recruiter/{jobTypeId}")
    public ResponseEntity<?> createJobPost(@RequestBody JobPost jobPost, @PathVariable("jobTypeId") Integer jobTypeId) {
//        jobPost.setJobTypeId(jobTypeRepository.findById(jobTypeId).orElseThrow(
//                ()->
//                        new ResourceNotFoundException("JobType not exist with id: "+ jobTypeId)
//        ));
        jobPostRepository.save(jobPost);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
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
