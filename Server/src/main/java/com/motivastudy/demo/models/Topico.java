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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topico")
public class Topico {

    public Topico(Long id){
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String urlPlaylist;

    @ManyToOne()
    @JoinColumn(name="disciplina_id", nullable=false)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "topico")
    private List<Questao> questao;
}
