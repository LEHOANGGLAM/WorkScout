package com.lehoangglam.workscout.controller;

import com.lehoangglam.workscout.entities.UserAccount;
import com.lehoangglam.workscout.entities.UserType;
import com.lehoangglam.workscout.repository.UserAccountRepository;
import com.lehoangglam.workscout.repository.UserTypeRepository;
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
public class UserRoleController {
    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("/role")
    public List<UserType> getAllRoles() {
        return userTypeRepository.findAll();
    }

}
