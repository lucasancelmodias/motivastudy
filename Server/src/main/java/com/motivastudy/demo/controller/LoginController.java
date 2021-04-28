package com.motivastudy.demo.controller;





import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.motivastudy.demo.dto.CadastroForm;
import com.motivastudy.demo.models.UsuarioDetailsImpl;
import com.motivastudy.demo.service.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<Map<String,String>> cadastro(@RequestBody @Valid CadastroForm form){
        
        return userService.cadastrarUsuario(form);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
