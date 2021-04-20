package com.motivastudy.demo;



import com.motivastudy.demo.models.Disciplina;
import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.repository.DisciplinaRepository;
import com.motivastudy.demo.repository.QuestaoRepository;
import com.motivastudy.demo.repository.TopicoRepository;
import com.motivastudy.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    QuestaoRepository questaoRepo;

    @Autowired
    DisciplinaRepository dispRepo;

    @Autowired
    TopicoRepository topRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario user = new Usuario();
        user.setNome("Nome");
        user.setSenha("Senha");
        user.setEmail(System.currentTimeMillis() + "email@gmail.com");
        user.setAtivo(true);
        usuarioRepo.save(user);
        Questao questao = new Questao();
        Disciplina disp = new Disciplina();

        disp.setNome("Matemática");
        disp = dispRepo.save(disp);
        Topico topico = new Topico();
        topico.setDisciplina(disp);
        topico.setNome("Geometria Analitica");
        topico.setUrlPlaylist("urlTest");
        topRepo.save(topico);
        questao.setEnunciado("Enem 2099");
        questao.setPeso(99);
        questao.setAlternativaCorreta("A");
        questao.setTextoApoio("Te vira ai amigao");
        questao.setValorAlternativaA("é essa memo");
        questao.setTopico(topico);
        questaoRepo.save(questao);
    }
    
}
