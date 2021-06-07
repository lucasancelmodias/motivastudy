package com.motivastudy.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motivastudy.demo.dto.QuestaoUsuarioRespostaDto;
import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.QuestaoUsuario;
import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.models.UsuarioDetailsImpl;
import com.motivastudy.demo.repository.QuestaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService {
    private QuestaoRepository questaoRepo;
    private QuestaoUsuarioService questaoUsuarioService;
    @Autowired
    public QuestaoService(QuestaoRepository questaoRepository, QuestaoUsuarioService questaoUsuarioService){
        this.questaoRepo = questaoRepository;
        this.questaoUsuarioService = questaoUsuarioService;
    }


    public List<Questao> findAll(){
        return questaoRepo.findAll();
    }

    public List<Questao> findByTopico(Topico topico){
        return questaoRepo.findByTopico(topico);
    }

    public Optional<Questao> findById(Long id){
        return questaoRepo.findById(id);
    }

    public Optional<Questao> findByIdAndAlternativaCorreta(Long id, String alternativaCorreta){
        return questaoRepo.findByIdAndAlternativaCorreta(id, alternativaCorreta);
    }

    public Questao save(Questao questao){
        return questaoRepo.save(questao);
    }

    public void delete(Questao questao){
        questaoRepo.delete(questao);
    }


    public ResponseEntity<String> responderQuestao(QuestaoUsuarioRespostaDto questaoResposta) throws JsonProcessingException {
        Map<String,Object> respBody = new HashMap<>();

                
        Optional<Questao> questao = questaoRepo.findById(questaoResposta.getIdQuestao());
        
        Boolean respostaCorreta = questao.map(ques -> {
            return validarResposta(ques, questaoResposta.getAlternativaRespondida());
        }).orElse(false);


        respBody.put("questao", questao.get().getId());
        respBody.put("respostaEstaCorreta", respostaCorreta);
        respBody.put("alternativaCorreta", questao.get().getAlternativaCorreta());
        respBody.put("alternativaRespondida", questaoResposta.getAlternativaRespondida());

        salvarRespostaUsuario(questao.isPresent() ? questao.get() : null, questaoResposta.getAlternativaRespondida());

        String response = new ObjectMapper().writeValueAsString(respBody);
        return ResponseEntity.ok().body(response);
    }


    private void salvarRespostaUsuario(Questao questao, String alternativaRespondida) {
        UsuarioDetailsImpl userDet =(UsuarioDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario user = userDet.getUsuario();

        QuestaoUsuario quesUser = new QuestaoUsuario();
        quesUser.setUsuario(user);
        quesUser.setQuestao(questao);
        quesUser.setAlternativaRespondida(alternativaRespondida);

        questaoUsuarioService.save(quesUser);
    }


    private Boolean validarResposta(Questao ques, String resp) {
        return ques.getAlternativaCorreta().equalsIgnoreCase(resp);
    }

}
