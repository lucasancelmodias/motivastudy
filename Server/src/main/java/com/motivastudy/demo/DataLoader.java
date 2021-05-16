package com.motivastudy.demo;




import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.motivastudy.demo.models.Disciplina;
import com.motivastudy.demo.models.Perfil;
import com.motivastudy.demo.models.Questao;
import com.motivastudy.demo.models.Topico;
import com.motivastudy.demo.models.Usuario;
import com.motivastudy.demo.repository.DisciplinaRepository;
import com.motivastudy.demo.repository.PerfilRepository;
import com.motivastudy.demo.repository.QuestaoRepository;
import com.motivastudy.demo.repository.TopicoRepository;
import com.motivastudy.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements ApplicationRunner{

    @Bean
    public PasswordEncoder passwordEncoding(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    QuestaoRepository questaoRepo;

    @Autowired
    DisciplinaRepository dispRepo;

    @Autowired
    TopicoRepository topRepo;

    @Autowired
    PerfilRepository perfilrepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        carregarPerfil();
        carregarUsuario();
        carregarDisciplina();
        
    }

    private void carregarPerfil() {
        Perfil perfil = new Perfil(Perfil.ADMIN);
        Perfil perfilAluno = new Perfil(Perfil.ALUNO);
        Perfil perfilProf = new Perfil(Perfil.PROFESSOR);

        Optional<Perfil> perfilAdminExiste = perfilrepo.findPerfilByNome(Perfil.ADMIN);
        Optional<Perfil> perfilAlunoExiste = perfilrepo.findPerfilByNome(Perfil.ALUNO);
        Optional<Perfil> perfilProfExiste = perfilrepo.findPerfilByNome(Perfil.PROFESSOR);

        if(perfilAdminExiste.isPresent() || perfilAlunoExiste.isPresent() || perfilProfExiste.isPresent()){
            return;
        }
        perfilrepo.save(perfil);
        perfilrepo.save(perfilAluno);
        perfilrepo.save(perfilProf);

    }

    private void carregarDisciplina() {
        Questao questao = new Questao();
        Disciplina disp = new Disciplina();
        Disciplina disp2 = new Disciplina();
        disp2.setNome("Geografia");
        disp.setNome("Matemática");
        disp = dispRepo.save(disp);
        dispRepo.save(disp2);
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

    private void carregarUsuario() {
        Usuario user = new Usuario(); 

        Optional<Usuario> usuarioExiste = usuarioRepo.findUsuarioByEmail("email@gmail.com");

        if(usuarioExiste.isPresent()){
            return;
        }
        Optional<Perfil> oPerfil = perfilrepo.findPerfilByNome(Perfil.ADMIN);
        Set<Perfil> perfis = new HashSet<>();
        if(oPerfil.isPresent()){
            perfis.add(oPerfil.get());
        }
        
        user.setNome("Usuario");
        user.setSenha(passwordEncoding().encode("senha1234"));
        user.setEmail("email@gmail.com");
        user.setAtivo(true);
        user.setPerfis(perfis);
        user.setDataAtivo(new Date());
        usuarioRepo.save(user);
    }
    
}
