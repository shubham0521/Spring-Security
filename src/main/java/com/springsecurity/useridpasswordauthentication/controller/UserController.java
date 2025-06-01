package com.springsecurity.useridpasswordauthentication.controller;

import com.springsecurity.useridpasswordauthentication.entity.User;
import com.springsecurity.useridpasswordauthentication.repository.UserRepository;
import com.springsecurity.useridpasswordauthentication.service.UserRegisteryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserRegisteryService  userRegisteryService;

    public UserController(UserRepository userRepository, UserRegisteryService userRegisteryService) {
        this.userRepository = userRepository;
        this.userRegisteryService = userRegisteryService;
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
        userRepository.save(user);
        return "user registered successfully";
    }
}
