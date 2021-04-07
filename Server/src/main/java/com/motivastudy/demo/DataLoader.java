package com.motivastudy.demo;



import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    UsuarioRepository usuarioRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario user = new Usuario();
        user.setNome("Nome");
        user.setSenha("Senha");
        user.setEmail("email@gmail.com");
        user.setAtivo(true);
        usuarioRepo.save(user);

    }
    
}
