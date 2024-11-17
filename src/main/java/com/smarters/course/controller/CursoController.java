package com.smarters.course.controller;

import org.springframework.web.bind.annotation.*;
import com.smarters.course.model.Curso;
import com.smarters.course.service.CursoService;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }
}

