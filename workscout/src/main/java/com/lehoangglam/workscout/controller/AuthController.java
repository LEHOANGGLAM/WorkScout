package com.lehoangglam.workscout.controller;


import com.lehoangglam.workscout.entities.UserType;
import com.lehoangglam.workscout.repository.UserAccountRepository;
import com.lehoangglam.workscout.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Autowired
//    JwtUtils jwtUtils;

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
//
//    }


//    @PostMapping("/signup")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignUpRequest signUpRequest){
//
//    }
}
