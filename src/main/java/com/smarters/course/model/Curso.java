package com.smarters.course.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    private LocalDate dataCriacao;

    public Curso() {
		super();
	}
    
	public Curso(Long id) {
		super();
		this.id = id;
	}
	
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private Set<Inscricao> inscricoes = new HashSet<>();

    @Transient
    public Set<Aluno> getAlunos() {
        Set<Aluno> alunos = new HashSet<>();
        for (Inscricao inscricao : inscricoes) {
            alunos.add(inscricao.getAluno());
        }
        
        return alunos;
    }

	public Long getId() {
		return id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
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

}
