package com.motivastudy.demo.controller;





import java.util.Map;

import com.motivastudy.demo.dto.CadastroForm;
import com.motivastudy.demo.models.UsuarioDetailsImpl;
import com.motivastudy.demo.service.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
    
    @Autowired
    UsuarioService userService;

    @RequestMapping("/user")
    public ResponseEntity<UsuarioDetailsImpl> user(){
        UsuarioDetailsImpl userDet =(UsuarioDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userDet);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String,String>> cadastro(@RequestBody CadastroForm form){
        
        return userService.cadastrarUsuario(form);

    }
}
