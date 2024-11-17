package com.smarters.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smarters.course.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
}

