package com.motivastudy.demo.service;


import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.motivastudy.demo.dto.CadastroForm;
import com.motivastudy.demo.models.Perfil;
import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.repository.UsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepo;
    private PerfilService perfilService;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PerfilService perfilService){
        this.usuarioRepo = usuarioRepository;
        this.perfilService = perfilService;
    }

    public Optional<Usuario> findByNome(Usuario usuario){
        return usuarioRepo.findUsuarioByNome(usuario.getNome());
    }

    public Optional<Usuario> findById(Usuario usuario){
        return usuarioRepo.findById(usuario.getId());
    }

    public Optional<Usuario> findByEmail(Usuario usuario){
        return usuarioRepo.findUsuarioByEmail(usuario.getEmail());
    }

    public List<Usuario> findAll(){
        return usuarioRepo.findAll();
    }

    public void save(Usuario usuario){
        usuarioRepo.save(usuario);
    }

    public void delete(Usuario usuario){
        usuarioRepo.delete(usuario);
    }

    public ResponseEntity<Map<String,String>> cadastrarUsuario(CadastroForm form) {
        Optional<Usuario> user = usuarioRepo.findUsuarioByEmail(form.getEmail());
        Map<String,String> message = new HashMap<>();
        if(user.isPresent()){
            message.put("message", "Usuário já cadastro com esse e-mail.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        
        if(!form.getSenha().equals(form.getSenhaconfirmacao())){
            message.put("message", "As senhas devem ser iguais");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        /*
        if(form.getSenha().equals("") || form.getSenhaconfirmacao().equals("")){
            message.put("message", "A senha não pode ser vazia");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        if(form.getNome().equals("") || form.getNome().length() < 2){
            message.put("message","O nome não pode ser vazio ou menor que 2 caracteres.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }*/
        Set<Perfil> perfis = new HashSet<>();
        Optional<Perfil> perfil = perfilService.findPerfilByNome(Perfil.ALUNO);
        if(perfil.isPresent()){
            perfis.add(perfil.get());
        }
        Usuario usuario = new Usuario();
        usuario.setNome(form.getNome());
        usuario.setEmail(form.getEmail());
        usuario.setAtivo(true);
        usuario.setDataAtivo(new Date());
        usuario.setPerfis(perfis);
        usuario.setSenha(passwordEncrypt().encode(form.getSenha()));
        usuarioRepo.save(usuario);
        message.put("message", "Usuário criado com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @Bean
    public PasswordEncoder passwordEncrypt(){
        return new BCryptPasswordEncoder();
    }
}
