package com.smarters.course.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscricao> inscricoes = new HashSet<>();

    @Transient
    public Set<Curso> getCursos() {
        Set<Curso> cursos = new HashSet<>();
        for (Inscricao inscricao : inscricoes) {
            cursos.add(inscricao.getCurso());
        }
        return cursos;
    }
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

