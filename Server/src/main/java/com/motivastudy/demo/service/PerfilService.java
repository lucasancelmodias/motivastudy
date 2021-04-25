package com.motivastudy.demo.service;

import java.util.List;
import java.util.Optional;

import com.motivastudy.demo.models.Perfil;
import com.motivastudy.demo.repository.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    private PerfilRepository perfilRepo;

    @Autowired
    public PerfilService(PerfilRepository perfilRepo){
        this.perfilRepo = perfilRepo;
    }

    public Optional<Perfil> findPerfilByNome(String nome){
        return perfilRepo.findPerfilByNome(nome);
    }

    public List<Perfil> findAll(){
        return perfilRepo.findAll();
    }

    public void save(Perfil perfil){
        perfilRepo.save(perfil);
    }

    public void delete(Perfil perfil){
        perfilRepo.delete(perfil);
    }
}
