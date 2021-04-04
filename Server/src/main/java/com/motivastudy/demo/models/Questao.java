package com.motivastudy.demo.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "questao")
public class Questao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @ManyToOne()
    @JoinColumn(name="questao_id", nullable=false)
    private Topico topico;


}
