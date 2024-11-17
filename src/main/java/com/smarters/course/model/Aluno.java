package com.smarters.course.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

    public Aluno() {
		super();
	}
    
	public Aluno(Long id) {
		super();
		this.id = id;
	}
	
	@ManyToMany(mappedBy = "alunos")
	@JsonIgnore
	private Set<Curso> cursos = new HashSet<>();


	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<Inscricao> inscricoes = new HashSet<>();
	
	

	public Long getId() {
		return id;
	}

	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
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
	
	
	
}

