package com.motivastudy.demo.service;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.QuestaoUsuario;
import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.repository.QuestaoUsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestaoUsuarioService {
    private QuestaoUsuarioRepository questaoUsuarioRepository;

    public QuestaoUsuarioService(QuestaoUsuarioRepository questaoUsuarioRepository){
        this.questaoUsuarioRepository = questaoUsuarioRepository;
    }


    public List<QuestaoUsuario> findByUsuario(Usuario usuario){
            return questaoUsuarioRepository.findByUsuario(usuario);
    } 

    public Optional<QuestaoUsuario> findById(Long id){
        return questaoUsuarioRepository.findById(id);
    }

    public Optional<QuestaoUsuario> findByQuestao(Questao questao){
        return questaoUsuarioRepository.findByQuestao(questao);
    }

    public void save(QuestaoUsuario questaoUsuario){
        questaoUsuarioRepository.save(questaoUsuario);
    }

    public void delete(QuestaoUsuario questaoUsuario){
        questaoUsuarioRepository.delete(questaoUsuario);
    }

}
