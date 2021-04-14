package com.motivastudy.demo.service;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.repository.QuestaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Questao> findById(Questao questao){
        return questaoRepo.findById(questao.getId());
    }

    public Optional<Questao> findByIdAndAlternativaCorreta(Long id, String alternativaCorreta){
        return questaoRepo.findByIdAndAlternativaCorreta(id, alternativaCorreta);
    }

}
