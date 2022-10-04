package com.lehoangglam.workscout.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess(){
        return "Public content";
    }

    @GetMapping("/jobseeker")
    @PreAuthorize("hasRole('jobseeker') or hasRole('recruiter')")
    public String jobseekerAccess(){
        return "JobSeeker content";
    }
    @GetMapping("/recruiter")
    @PreAuthorize("hasRole('recruiter')")
    public String recruiterAccess(){
        return "Recruiter content";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String adminAccess(){
        return "Admin content";
    }

}
