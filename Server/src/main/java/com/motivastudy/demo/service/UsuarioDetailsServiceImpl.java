package com.motivastudy.demo.service;

import java.util.Optional;

import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.models.UsuarioDetailsImpl;
import com.motivastudy.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepo.findUsuarioByEmail(username);

        if(usuario.isPresent()){
            return new UsuarioDetailsImpl(usuario.get());
        }else {
            throw new UsernameNotFoundException("Usuário ou senha inválidos");
        }
    }
    
}
