package com.eventos.projeto.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Inscricao {
    @Id
    @GeneratedValue
    private Long id;

    private String nomeParticipante;
    private String cpf;
    private String email;
    private String curso;

    @ManyToOne
		@JsonBackReference
    private Evento evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeParticipante() {
		return nomeParticipante;
	}

	public void setNomeParticipante(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
    
    
}
