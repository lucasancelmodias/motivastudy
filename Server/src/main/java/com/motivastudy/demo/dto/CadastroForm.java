package com.motivastudy.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CadastroForm {

    @Email(message = "Formato de e-mail inválido.")
    private String email;
    @NotEmpty
    @Size(min = 2, message = "O nome não pode ser vazio ou menor que 2 caracteres.")
    private String nome;
    @NotEmpty
    private String senha;
    @NotEmpty
    private String senhaconfirmacao;
}
