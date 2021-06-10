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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonBackReference
    private Disciplina disciplina;

    @OneToMany(mappedBy = "topico")
    @JsonManagedReference
    private List<Questao> questao;
}
