package com.motivastudy.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.repository.QuestaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestaoService {
    private QuestaoRepository questaoRepo;

    @Autowired
    public QuestaoService(QuestaoRepository questaoRepository){
        this.questaoRepo = questaoRepository;
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


    public ResponseEntity<String> responderQuestao(String val) throws JsonProcessingException {
        Long id = 1L;
        String resp = "A";
        Map<String,Object> respBody = new HashMap<>();

                
        Optional<Questao> questao = questaoRepo.findById(id);
        
        Boolean respostaCorreta = questao.map(ques -> {
            return validarResposta(ques, resp);
        }).orElse(false);
        respBody.put("resp", respostaCorreta);
        String response = new ObjectMapper().writeValueAsString(respBody);
        return ResponseEntity.ok().body(response);
    }


    private Boolean validarResposta(Questao ques, String resp) {
        return ques.getAlternativaCorreta().equalsIgnoreCase(resp);
    }

}
