package com.smarters.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarters.course.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> { }

