package com.motivastudy.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.motivastudy.demo.dto.QuestaoResponse;
import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.service.QuestaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/questoes")
public class QuestaoController {
    @Autowired
    private QuestaoService questaoService;
    @GetMapping(value="/{id}")
    public ResponseEntity<QuestaoResponse> getQuestao(@PathVariable String id) {

        Long idParam = Long.parseLong(id);
        Optional<Questao> questaoOp = questaoService.findById(idParam);
        if(questaoOp.isPresent()){
            
            return ResponseEntity.ok(QuestaoResponse.buildQuestaoResponse(questaoOp.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<QuestaoResponse> cadastroQuestao(@RequestBody QuestaoResponse qRes){
        QuestaoResponse questao = QuestaoResponse.buildQuestaoResponse(questaoService.save(qRes.transformaQuestao()));

        return new ResponseEntity<>(questao, HttpStatus.CREATED);
    }

    @GetMapping(value = "/topico/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuestaoResponse>> questaoTopico(@PathVariable Long id){
        List<QuestaoResponse> questao = new ArrayList<>();
        List<Questao> lsQuestao = questaoService.findByTopico(new Topico(id));
        lsQuestao.forEach(ques -> questao.add(QuestaoResponse.buildQuestaoResponse(ques)));

        return new ResponseEntity<>(questao, HttpStatus.OK);
    }
    
    @PostMapping("/responder")
    public ResponseEntity<String> responderQuestao(@RequestBody String val) throws JsonProcessingException{
        questaoService.responderQuestao(val);
        return ResponseEntity.ok().body("ok");
    }
}
