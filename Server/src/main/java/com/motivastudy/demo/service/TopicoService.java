package com.motivastudy.demo.service;

import java.util.Optional;

import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.repository.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    private TopicoRepository topicoRepository;

    @Autowired
    public TopicoService(TopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }

    public Optional<Topico> findById(Long id){
        return topicoRepository.findById(id);
    }

    public Optional<Topico> findByNome(String nome){
        return topicoRepository.findByNome(nome);
    }

    public Optional<Topico> findByurlPlaylist(String url){
        return topicoRepository.findByurlPlaylist(url);
    }
}
