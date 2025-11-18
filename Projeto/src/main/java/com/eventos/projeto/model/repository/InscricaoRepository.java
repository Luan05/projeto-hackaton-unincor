package com.eventos.projeto.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.projeto.model.domain.Inscricao;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByEventoId(Long eventoId);
}
