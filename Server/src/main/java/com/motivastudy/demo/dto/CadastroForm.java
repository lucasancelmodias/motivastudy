package com.motivastudy.demo.dto;

import lombok.Data;

@Data
public class CadastroForm {
    private String email;
    private String nome;
    private String senha;
    private String senhaconfirmacao;
}
