package com.springsecurity.useridpasswordauthentication.service.impl;

import com.springsecurity.useridpasswordauthentication.entity.User;
import com.springsecurity.useridpasswordauthentication.repository.UserRepository;
import com.springsecurity.useridpasswordauthentication.service.UserRegisteryService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisteryServiceImpl implements UserRegisteryService {

    private final UserRepository  userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegisteryServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User registerUsers(User users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }
}
