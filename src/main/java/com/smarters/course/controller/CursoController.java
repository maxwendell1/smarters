package com.smarters.course.controller;

import org.springframework.web.bind.annotation.*;

import com.smarters.course.dto.CursoDTO;
import com.smarters.course.model.Curso;
import com.smarters.course.populator.InscricaoPopulator;
import com.smarters.course.service.CursoService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;
    private final InscricaoPopulator populator;

    public CursoController(CursoService cursoService, InscricaoPopulator populator) {
        this.cursoService = cursoService;
        this.populator = populator;
    }

    @PostMapping
    public CursoDTO createCurso(@RequestBody Curso curso) {
        return populator.toCursoDTO(cursoService.saveCurso(curso));
    }

    @GetMapping
    public List<CursoDTO> getAllCursos() {
    	
       
         return cursoService.findAll()
                .stream()
                .map(populator::toCursoDTO)
                .collect(Collectors.toList());
       
    }
}

