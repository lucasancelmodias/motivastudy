package com.motivastudy.demo.repository;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    
    List<Disciplina> findAll();
    Optional<Disciplina> findById(Long id);
    Optional<Disciplina> findByNome(String nome);
    
}
