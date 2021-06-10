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
        //carregarDisciplina();
        
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
        Disciplina matematica = new Disciplina();
        Disciplina matematica2 = new Disciplina();
        Disciplina geografia = new Disciplina();
        Disciplina historia = new Disciplina();

        geografia.setNome("Geografia");
        matematica.setNome("Matemática");
        matematica2.setNome("Matemática II");
        historia.setNome("História");
       
        matematica = dispRepo.save(matematica);
        dispRepo.save(geografia);
        matematica2 = dispRepo.save(matematica2);
        historia = dispRepo.save(historia);


        Topico geometria = new Topico();
        geometria.setDisciplina(matematica);
        geometria.setNome("Geometria Analitica");
        geometria.setUrlPlaylist("urlTest");
        topRepo.save(geometria);

        Topico trignometria = new Topico();
        trignometria.setDisciplina(matematica2);
        trignometria.setNome("Trigonometria");
        trignometria.setUrlPlaylist("PLf1lowbdbFIDyVckJbycSHH4FVwdOc2Gd");
        topRepo.save(trignometria);
        
        Topico agricultura = new Topico();
        agricultura.setDisciplina(geografia);
        agricultura.setNome("Agricultura e meio ambiente");
        agricultura.setUrlPlaylist("urlTest");
        topRepo.save(agricultura);

        Topico historiaGeral = new Topico();

        historiaGeral.setDisciplina(historia);
        historiaGeral.setNome("História Geral");
        historiaGeral.setUrlPlaylist("urltest");
        topRepo.save(historiaGeral);

        questao.setEnunciado("Enem 2099");
        questao.setPeso(99);
        questao.setAlternativaCorreta("A");
        questao.setTextoApoio("Te vira ai amigao");
        questao.setValorAlternativaA("é essa memo");
        questao.setValorAlternativaB("talvez é essa");
        questao.setValorAlternativaC("essa aqui talvez?");
        questao.setValorAlternativaD("hummmmmmm");
        questao.setValorAlternativaE("será????");
        questao.setTopico(geometria);
        questaoRepo.save(questao);
    }

    private void carregarUsuario() {
        Usuario user = new Usuario(); 
        Usuario professor = new Usuario();
        Usuario aluno = new Usuario();
        Optional<Usuario> usuarioExiste = usuarioRepo.findUsuarioByEmail("admin@email.com");
        Optional<Usuario> usuarioProfessorExiste = usuarioRepo.findUsuarioByEmail("professor@email.com");
        Optional<Usuario> usuarioAlunoExiste = usuarioRepo.findUsuarioByEmail("aluno@email.com");
        if(usuarioExiste.isPresent() || usuarioProfessorExiste.isPresent() || usuarioAlunoExiste.isPresent()){
            return;
        }
        
        Optional<Perfil> oPerfil = perfilrepo.findPerfilByNome(Perfil.ADMIN);
        Optional<Perfil> oPerfilProfessor = perfilrepo.findPerfilByNome(Perfil.PROFESSOR);
        Optional<Perfil> oPerfilAluno = perfilrepo.findPerfilByNome(Perfil.ALUNO);

        Set<Perfil> perfis = new HashSet<>();
        Set<Perfil> perfisProfessor = new HashSet<>();
        Set<Perfil> perfisAluno = new HashSet<>();

        if(oPerfil.isPresent() || oPerfilProfessor.isPresent() || oPerfilAluno.isPresent()){
            perfis.add(oPerfil.get());
            perfisProfessor.add(oPerfilProfessor.get());
            perfisAluno.add(oPerfilAluno.get());
        }
        
        user.setNome("Usuário Admin");
        user.setSenha(passwordEncoding().encode("senha1234"));
        user.setEmail("admin@email.com");
        user.setAtivo(true);
        user.setPerfis(perfis);
        user.setDataAtivo(new Date());
        usuarioRepo.save(user);

        professor.setNome("Usuário Professor");
        professor.setSenha(passwordEncoding().encode("senha1234"));
        professor.setEmail("professor@email.com");
        professor.setAtivo(true);
        professor.setPerfis(perfisProfessor);
        professor.setDataAtivo(new Date());
        usuarioRepo.save(professor);


        aluno.setNome("Usuário Aluno");
        aluno.setSenha(passwordEncoding().encode("senha1234"));
        aluno.setEmail("aluno@email.com");
        aluno.setAtivo(true);
        aluno.setPerfis(perfisAluno);
        aluno.setDataAtivo(new Date());
        usuarioRepo.save(aluno);
    }
    
}
