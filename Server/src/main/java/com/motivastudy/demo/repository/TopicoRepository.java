package com.motivastudy.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.motivastudy.demo.models.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Integer> {
    
    Optional<Topico> findById(Long id);
    Optional<Topico> findByNome(String nome);
    Optional<Topico> findByurlPlaylist(String url);
}