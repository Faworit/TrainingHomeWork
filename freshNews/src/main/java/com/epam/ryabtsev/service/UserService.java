package com.epam.ryabtsev.service;

import com.epam.ryabtsev.repository.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserReposiroty userReposiroty;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("test get username: " + username);
        return (UserDetails) userReposiroty.findByUsername(username);
    }
}
