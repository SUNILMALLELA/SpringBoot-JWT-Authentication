package com.example.SpringBoot.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/user")
     public String user(){
         return "Welcome User";
     }
     @PreAuthorize("hasRole('ADMIN')")
     @GetMapping("/admin")
     public String admin(){
        return "Welcome Admin";
     }
    @PostAuthorize("returnObject == authentication.name")
    @GetMapping("/profile/{username}")
    public String getProfile(@PathVariable String username) {
        return username;
    }
}
