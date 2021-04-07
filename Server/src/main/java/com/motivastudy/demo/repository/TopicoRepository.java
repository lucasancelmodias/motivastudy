package com.motivastudy.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.motivastudy.demo.models.Usuario;

public interface TopicoRepository extends JpaRepository<User, Integer> {
    
    Optional<Usuario> findById(String id);
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByURL(String url);
}