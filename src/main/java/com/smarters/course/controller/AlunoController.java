package com.smarters.course.controller;

import org.springframework.web.bind.annotation.*;
import com.smarters.course.model.Aluno;
import com.smarters.course.dto.AlunoDTO;
import com.smarters.course.service.AlunoService;
import com.smarters.course.populator.InscricaoPopulator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;
    private final InscricaoPopulator populator;

    public AlunoController(AlunoService alunoService, InscricaoPopulator populator) {
        this.alunoService = alunoService;
        this.populator = populator;
    }

    @PostMapping
    public AlunoDTO createAluno(@RequestBody Aluno aluno) {
        return populator.toAlunoDTO(alunoService.saveAluno(aluno));
    }

    @GetMapping
    public List<AlunoDTO> getAllAlunos() {
        return alunoService.findAll()
                .stream()
                .map(populator::toAlunoDTO)
                .collect(Collectors.toList());
    }
}


