package com.smarters.course.service;

import org.springframework.stereotype.Service;
import com.smarters.course.model.Curso;
import com.smarters.course.repository.CursoRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso saveCurso(Curso curso) {
        curso.setDataCriacao(LocalDate.now());
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
}

