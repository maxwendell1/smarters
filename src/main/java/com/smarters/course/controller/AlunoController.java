package com.smarters.course.controller;

import org.springframework.web.bind.annotation.*;
import com.smarters.course.model.Aluno;
import com.smarters.course.service.AlunoService;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.saveAluno(aluno);
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.findAll();
    }
}

