package com.smarters.course.service;

import org.springframework.stereotype.Service;
import com.smarters.course.model.Aluno;
import com.smarters.course.repository.AlunoRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno saveAluno(Aluno aluno) {
        aluno.setDataCadastro(LocalDate.now());
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
}
