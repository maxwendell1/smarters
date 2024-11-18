package com.smarters.course.service;

import com.smarters.course.model.Aluno;
import com.smarters.course.model.Curso;
import com.smarters.course.model.Inscricao;
import com.smarters.course.repository.AlunoRepository;
import com.smarters.course.repository.CursoRepository;
import com.smarters.course.repository.InscricaoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoService {

	private final InscricaoRepository inscricaoRepository;
	private final CursoRepository cursoRepository;
	private final AlunoRepository alunoRepository;

	public InscricaoService(InscricaoRepository inscricaoRepository, AlunoRepository alunoRepository,
			CursoRepository cursoRepository) {
		this.inscricaoRepository = inscricaoRepository;
		this.cursoRepository = cursoRepository;
		this.alunoRepository = alunoRepository;
	}

	public Inscricao inscreverAluno(Long alunoId, Long cursoId) {
		Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
		Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso não encontrado"));

		Inscricao inscricao = new Inscricao();
		inscricao.setAluno(aluno);
		inscricao.setCurso(curso);
		inscricao.setDataInscricao(LocalDate.now());

		return inscricaoRepository.save(inscricao);
	}

	public List<Inscricao> listarCursosDoAluno(Long alunoId) {
		return inscricaoRepository.findByAlunoId(alunoId);
	}

	public List<Inscricao> listarAlunosDoCurso(Long cursoId) {
		return inscricaoRepository.findByCursoId(cursoId);
	}
}