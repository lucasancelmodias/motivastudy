package com.motivastudy.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.motivastudy.demo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findUsuarioByNome(String nome);
    Optional<Usuario> findUsuarioByEmail(String email);
    Optional<Usuario> findUsuarioById(Long id);
    Optional<Usuario> findByToken(String token);

    List<Usuario> findAll();
}