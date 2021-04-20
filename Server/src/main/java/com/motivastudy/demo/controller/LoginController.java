package com.motivastudy.demo.controller;


import com.motivastudy.demo.dto.LoginDto;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @PostMapping("/login")
    public ResponseEntity<String> loginPage(@RequestBody LoginDto logindto){
        return ResponseEntity.ok().body("login dto ok");
    }
}
