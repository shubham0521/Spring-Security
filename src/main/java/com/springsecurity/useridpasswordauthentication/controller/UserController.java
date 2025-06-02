package com.springsecurity.useridpasswordauthentication.controller;

import com.springsecurity.useridpasswordauthentication.entity.User;
import com.springsecurity.useridpasswordauthentication.repository.UserRepository;
import com.springsecurity.useridpasswordauthentication.service.JwtService;
import com.springsecurity.useridpasswordauthentication.service.UserRegisteryService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserRegisteryService  userRegisteryService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authManager;

    public UserController(UserRepository userRepository, UserRegisteryService userRegisteryService, JwtService jwtService, UserDetailsService userDetailsService, AuthenticationManager authManager) {
        this.userRepository = userRepository;
        this.userRegisteryService = userRegisteryService;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.authManager = authManager;
    }

    @GetMapping("/hello")
    public String sayHelloToUsers() {
        return "Hello World";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRegisteryService.registerUsers(user);
        return "user registered successfully";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String jwt = jwtService.generateToken(userDetails);
        return jwt;
    }
}
