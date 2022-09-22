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

    @GetMapping("/user")
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserAccount> getUserByName(@PathVariable String username) {
        UserAccount user = userAccountRepository.findByUsername(username);
        return ResponseEntity.ok(user);
    }
//    @GetMapping("/companies/{id}")
//    public ResponseEntity<UserAccount> getUserByUsername(@PathVariable String username){
//        UserAccount user = userAccountRepository.findAll(id).orElseThrow(()->
//                new ResourceNotFoundException("User not exist with Username: "+ id));
//        return ResponseEntity.ok(user);
//    }


}




