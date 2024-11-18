package com.smarters.course.controller;

import com.smarters.course.model.Inscricao;
import com.smarters.course.service.InscricaoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;
    
    
    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public Inscricao inscreverAluno(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        return inscricaoService.inscreverAluno(alunoId, cursoId);
    }

    @GetMapping("/aluno/{alunoId}")
    public List<Inscricao> listarCursosDoAluno(@PathVariable Long alunoId) {
        return inscricaoService.listarCursosDoAluno(alunoId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Inscricao> listarAlunosDoCurso(@PathVariable Long cursoId) {
        return inscricaoService.listarAlunosDoCurso(cursoId);
    }
}

