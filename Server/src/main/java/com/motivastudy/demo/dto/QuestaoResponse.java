package com.motivastudy.demo.dto;

import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoResponse {
    private Long id;

    private String enunciado;

    private String textoApoio;

    private String alternativaCorreta;

    private Integer peso;

    private String valorAlternativaA;
    
    private String valorAlternativaB;
    
    private String valorAlternativaC;
    
    private String valorAlternativaD;

    private String valorAlternativaE;

    private Long topicoId;

    public static QuestaoResponse buildQuestaoResponse(Questao questao){
        return new QuestaoResponse(
        questao.getId(),
        questao.getEnunciado(),
        questao.getTextoApoio(),
        questao.getAlternativaCorreta(),
        questao.getPeso(),
        questao.getValorAlternativaA(),
        questao.getValorAlternativaB(),
        questao.getValorAlternativaC(),
        questao.getValorAlternativaD(),
        questao.getValorAlternativaE(),
        questao.getTopico().getId());
    }

    public Questao transformaQuestao(){
        return new Questao(
        this.id, 
        this.enunciado, 
        this.textoApoio, 
        this.alternativaCorreta, 
        this.peso, 
        this.valorAlternativaA, 
        this.valorAlternativaB, 
        this.valorAlternativaC,
        this.valorAlternativaD,
        this.valorAlternativaE,
        new Topico(this.topicoId)
        );
    }
}
