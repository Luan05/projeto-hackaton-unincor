package com.eventos.projeto.dto;

import com.eventos.projeto.model.domain.Evento;

public class EventoDto {
  private Long id;
  private String nome;
  private String data;
  private String descricao;
  private int quantidadeInscricoes;

  // construtor
  public EventoDto(Evento evento) {
    this.id = evento.getId();
    this.nome = evento.getNome();
    this.data = evento.getData();
    this.descricao = evento.getDescricao();
    this.quantidadeInscricoes = evento.getInscricoes() != null ? evento.getInscricoes().size() : 0;
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

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public int getQuantidadeInscricoes() {
    return quantidadeInscricoes;
  }

  public void setQuantidadeInscricoes(int quantidadeInscricoes) {
    this.quantidadeInscricoes = quantidadeInscricoes;
  }

}
