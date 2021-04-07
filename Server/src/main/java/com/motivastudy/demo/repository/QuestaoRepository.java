package com.motivastudy.demo.repository;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    
    List<Questao> findAll();
    List<Questao> findByTopico(Topico topico); 
    Optional<Questao> findById(Long id);
    Optional<Questao> findByIdAndAlternativaCorreta(Long id, String alternativaCorreta);
    
}
