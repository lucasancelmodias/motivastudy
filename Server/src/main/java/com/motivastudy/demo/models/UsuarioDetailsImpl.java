package com.motivastudy.demo.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
@Getter
public class UsuarioDetailsImpl implements UserDetails {
    private Usuario usuario;

    public UsuarioDetailsImpl(Usuario usuario){
        this.usuario = usuario;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Perfil> perfis = usuario.getPerfis();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Perfil perfil: perfis){
            authorities.add(new SimpleGrantedAuthority(perfil.getNome()));
        }
        return authorities;
    }
    @JsonIgnore
    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return usuario.getAtivo();
    }
    
}
