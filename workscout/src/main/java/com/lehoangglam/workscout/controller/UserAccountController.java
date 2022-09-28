package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.entities.UserAccount;
import com.lehoangglam.workscout.exception.ResourceNotFoundException;
import com.lehoangglam.workscout.repository.JobPostRepository;
import com.lehoangglam.workscout.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UserAccount> getUserByName(@PathVariable String username) {
        UserAccount user = userAccountRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }


    @PostMapping("/users")
    public UserAccount userRegistration(@RequestBody UserAccount user) {
        return userAccountRepository.save(user);
    }
}




