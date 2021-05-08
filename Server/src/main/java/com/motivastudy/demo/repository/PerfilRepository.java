package com.motivastudy.demo.repository;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {

    Optional<Perfil> findPerfilByNome(String nome);

    List<Perfil> findAll();
}
