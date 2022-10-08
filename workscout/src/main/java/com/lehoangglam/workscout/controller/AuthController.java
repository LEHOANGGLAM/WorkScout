package com.lehoangglam.workscout.controller;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.lehoangglam.workscout.entities.UserAccount;
import com.lehoangglam.workscout.entities.UserType;
import com.lehoangglam.workscout.payload.request.LoginRequest;
import com.lehoangglam.workscout.payload.request.SignupRequest;
import com.lehoangglam.workscout.payload.response.JwtResponse;
import com.lehoangglam.workscout.payload.response.MessageResponse;
import com.lehoangglam.workscout.repository.UserAccountRepository;
import com.lehoangglam.workscout.repository.UserTypeRepository;
import com.lehoangglam.workscout.security.jwt.JwtUtils;
import com.lehoangglam.workscout.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getImage(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userAccountRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userAccountRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        UserAccount user = new UserAccount(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        int roleId = signUpRequest.getRole();
        System.out.println("role: " + signUpRequest.getRole());
        switch (roleId) {
            case 1:
                UserType adminRole = userTypeRepository.findById(1)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setUserTypeId(adminRole);

                break;
            case 3:
                UserType recruiterRole = userTypeRepository.findById(3)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setUserTypeId(recruiterRole);

                break;
            case 2:
                UserType userRole = userTypeRepository.findById(2)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                user.setUserTypeId(userRole);
                break;
        }
        userAccountRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}