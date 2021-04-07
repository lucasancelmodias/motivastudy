package com.motivastudy.demo.repository;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.QuestaoUsuario;
import com.motivastudy.demo.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoUsuarioRepository extends JpaRepository<QuestaoUsuario, Long>{

    Optional<QuestaoUsuario> findById(Long id);

    List<QuestaoUsuario> findByUsuario(Usuario usuario);

    Optional<QuestaoUsuario> findByQuestao(Questao questao);
    
}
