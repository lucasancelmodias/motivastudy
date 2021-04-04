package com.motivastudy.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name = "perfis")
@Data
public class Perfil {
    public static final String ALUNO = "ALUNO";
    public static final String PROFESSOR = "PROFESSOR";
    public static final String ADMIN = "ADMIN";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty
    private String nome;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;
}
