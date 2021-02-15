package com.ahmetbalcikli.springSecurityDemo.user.service;

import com.ahmetbalcikli.springSecurityDemo.user.entity.Role;
import com.ahmetbalcikli.springSecurityDemo.user.entity.User;
import com.ahmetbalcikli.springSecurityDemo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
