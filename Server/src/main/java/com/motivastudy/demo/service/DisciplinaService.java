package com.motivastudy.demo.service;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Disciplina;
import com.motivastudy.demo.repository.DisciplinaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository){
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findById(Long id){
        return disciplinaRepository.findById(id);
    }
    public Optional<Disciplina> findByNome(String nome){
        return disciplinaRepository.findByNome(nome);
    }

    public void save(Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }

    public void delete(Disciplina disciplina){
        disciplinaRepository.delete(disciplina);
    }
}
