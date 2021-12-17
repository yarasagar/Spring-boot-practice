package com.java.techie.securityjwtexample.controller;

import com.java.techie.securityjwtexample.entity.JWTRequest;
import com.java.techie.securityjwtexample.entity.JWTResponse;
import com.java.techie.securityjwtexample.service.CustomUserDetailsService;
import com.java.techie.securityjwtexample.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getPassword(),
                            jwtRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }

        final UserDetails userDetails =
                customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
        final String token = jwtUtility.generateToken(userDetails);
        return new JWTResponse(token);
    }
}
