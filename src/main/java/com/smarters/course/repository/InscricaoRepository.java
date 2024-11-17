package com.smarters.course.repository;

import com.smarters.course.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByAlunoId(Long alunoId);
    List<Inscricao> findByCursoId(Long cursoId);
}

