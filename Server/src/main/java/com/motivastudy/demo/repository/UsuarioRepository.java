package com.motivastudy.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.motivastudy.demo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<User, Integer> {
    
    Optional<Usuario> findByNome(String nome);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findById(String id);
}