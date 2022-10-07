package com.lehoangglam.workscout.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class TestController {
    @GetMapping("/all")
    public String allAccess(){
        return "Public content";
    }

    @GetMapping("/jobseeker")
    @PreAuthorize("hasAuthority('jobseeker')")
    public String jobseekerAccess(){
        return "JobSeeker content";
    }
    @GetMapping("/recruiter")
    @PreAuthorize("hasAuthority('recruiter')")
    public String recruiterAccess(){
        return "Recruiter content";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String adminAccess(){
        return "Admin content";
    }

}
