package com.motivastudy.demo.service;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepo;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepo = usuarioRepository;
    }

    public Optional<Usuario> findByNome(Usuario usuario){
        return usuarioRepo.findByNome(usuario.getNome());
    }

    public Optional<Usuario> findById(Usuario usuario){
        return usuarioRepo.findById(usuario.getId());
    }

    public Optional<Usuario> findByEmail(Usuario usuario){
        return usuarioRepo.findByEmail(usuario.getEmail());
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
}
