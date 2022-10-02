package com.lehoangglam.workscout.services;

import com.lehoangglam.workscout.entities.UserAccount;
import com.lehoangglam.workscout.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAccount user = userAccountRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not exist with username " + username);
        }
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(String.valueOf(user.getUserTypeId())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);

    }
}
