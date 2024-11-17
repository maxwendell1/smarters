package com.smarters.course.popuator;

import org.springframework.stereotype.Component;
import com.smarters.course.dto.AlunoDTO;
import com.smarters.course.dto.CursoDTO;
import com.smarters.course.model.Aluno;
import com.smarters.course.model.Curso;

@Component
public class InscricaoPopulator {
    public AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        return dto;
    }

    public CursoDTO toCursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        return dto;
    }
}
