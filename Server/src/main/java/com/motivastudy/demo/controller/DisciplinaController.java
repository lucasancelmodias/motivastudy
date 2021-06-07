package com.motivastudy.demo.controller;

import java.util.List;

import com.motivastudy.demo.models.Disciplina;
import com.motivastudy.demo.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public ResponseEntity<List<Disciplina>> getAll(){
        return ResponseEntity.ok().body(disciplinaRepository.findAll());
    }
}
