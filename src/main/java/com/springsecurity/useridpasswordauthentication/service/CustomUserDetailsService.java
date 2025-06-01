package com.springsecurity.useridpasswordauthentication.service;

import com.springsecurity.useridpasswordauthentication.dto.CustomUsers;
import com.springsecurity.useridpasswordauthentication.entity.User;
import com.springsecurity.useridpasswordauthentication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User fetchUserFromRepo = userRepository.findByUsername(username);
        if(ObjectUtils.isEmpty(fetchUserFromRepo)) {
            System.out.println("no user found");
            throw new UsernameNotFoundException("no user found");
        }
        return new CustomUsers(fetchUserFromRepo);
    }
}
