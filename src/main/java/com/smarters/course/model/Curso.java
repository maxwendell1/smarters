package com.smarters.course.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataCriacao;

	@OneToMany(mappedBy = "curso")
	@JsonBackReference
	private Set<Inscricao> inscricoes = new HashSet<>();

	public Curso() {
		super();
	}

	public Curso(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public Set<Aluno> getAlunos() {
		Set<Aluno> alunos = new HashSet<>();
		for (Inscricao inscricao : inscricoes) {
			alunos.add(inscricao.getAluno());
		}
		return alunos;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}
