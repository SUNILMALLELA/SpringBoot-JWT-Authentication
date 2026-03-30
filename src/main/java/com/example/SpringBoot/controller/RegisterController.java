package com.example.SpringBoot.controller;

import com.example.SpringBoot.dto.RegisterRequest;
import com.example.SpringBoot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {
    @Autowired
    private final RegisterService authService;
    public RegisterController(RegisterService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest register){
        return  authService.createRegister(register);
    }
}
