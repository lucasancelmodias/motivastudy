package com.motivastudy.demo.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @NotEmpty
    @JsonIgnore
    private String senha;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    @Email(message = "Formato de e-mail inválido.")
    private String email;

    private String token;

    private Boolean ativo;

    private Date dataAtivo;

    private String anotacao;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
        name="usuario_perfil",
        joinColumns = {@JoinColumn(name="usuario_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name="perfil_id", referencedColumnName = "id")}
    )
    @JsonManagedReference
    private Set<Perfil> perfis = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requisicao_professor_id", referencedColumnName = "id")
    private RequisicaoProfessor requisicaoProfessor;
 
}
