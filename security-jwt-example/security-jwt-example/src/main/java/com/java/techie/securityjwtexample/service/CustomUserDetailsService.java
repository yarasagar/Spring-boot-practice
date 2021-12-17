package com.java.techie.securityjwtexample.service;

import com.java.techie.securityjwtexample.entity.User;
import com.java.techie.securityjwtexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(
                "user1", "pwd1", new ArrayList<>());
//                user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
