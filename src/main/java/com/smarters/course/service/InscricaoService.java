package com.smarters.course.service;

import com.smarters.course.model.Aluno;
import com.smarters.course.model.Curso;
import com.smarters.course.model.Inscricao;
import com.smarters.course.repository.InscricaoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public Inscricao inscreverAluno(Long alunoId, Long cursoId) {
        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(new Aluno(alunoId));
        inscricao.setCurso(new Curso(cursoId));
        inscricao.setDataInscricao(LocalDate.now());
        return inscricaoRepository.save(inscricao);
    }

    public List<Inscricao> listarCursosDoAluno(Long alunoId) {
        return inscricaoRepository.findByAlunoId(alunoId);
    }

    public List<Inscricao> listarAlunosDoCurso(Long cursoId) {
        return inscricaoRepository.findByCursoId(cursoId);
    }
}

