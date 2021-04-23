package com.motivastudy.demo.controller;


import java.security.Principal;

import com.motivastudy.demo.dto.LoginDto;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    /*@RequestMapping("/login")
    public boolean login(@RequestBody LoginDto user){
        return user.getUsername().equals("user") && user.getPassword().equals("password");
    }*/

    @RequestMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
