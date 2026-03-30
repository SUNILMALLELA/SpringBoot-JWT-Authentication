package com.example.SpringBoot.service;

import com.example.SpringBoot.dto.RegisterRequest;
import com.example.SpringBoot.entity.User;
import com.example.SpringBoot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public String createRegister(RegisterRequest register){
        if(userRepository.existsByUsername(register.getUsername())){
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(register.getUsername());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "User Registered Sucessfully";
    }



}
