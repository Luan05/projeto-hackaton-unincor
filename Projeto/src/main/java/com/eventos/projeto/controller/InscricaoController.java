package com.eventos.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.projeto.model.domain.Evento;
import com.eventos.projeto.model.domain.Inscricao;
import com.eventos.projeto.model.repository.EventoRepository;
import com.eventos.projeto.model.repository.InscricaoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inscricoes")
@RequiredArgsConstructor
public class InscricaoController {
	
	@Autowired
    private InscricaoRepository inscricaoRepository;
	@Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public Inscricao criar(@RequestBody Inscricao inscricao) {
        Evento evento = eventoRepository.findById(inscricao.getEvento().getId()).orElseThrow();
        inscricao.setEvento(evento);
        return inscricaoRepository.save(inscricao);
    }

    @GetMapping("/evento/{id}")
    public List<Inscricao> listarPorEvento(@PathVariable Long id) {
        return inscricaoRepository.findByEventoId(id);
    }
}
