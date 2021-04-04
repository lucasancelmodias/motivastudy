package com.motivastudy.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "topico")
public class Topico {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String urlPlaylist;

    @ManyToOne()
    @JoinColumn(name="topico_id", nullable=false)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "topico")
    private List<Questao> questao;
}
