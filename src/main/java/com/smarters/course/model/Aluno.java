package com.smarters.course.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataCadastro;

	@OneToMany(mappedBy = "aluno")
	@JsonBackReference
	private Set<Inscricao> inscricoes = new HashSet<>();

	public Aluno() {
		super();
	}

	public Aluno(Long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}

