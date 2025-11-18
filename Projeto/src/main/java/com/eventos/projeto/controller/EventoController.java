package com.eventos.projeto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.projeto.dto.EventoDto;
import com.eventos.projeto.model.domain.Evento;
import com.eventos.projeto.model.repository.EventoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
public class EventoController {
	
    private final EventoRepository eventoRepository;

    @GetMapping
    public List<EventoDto> listar() {
        return eventoRepository.findAll()
        .stream()
        .map(EventoDto::new)
        .toList();
    }

    @PostMapping
    public EventoDto criar(@RequestBody Evento evento) {
        Evento salvo = eventoRepository.save(evento);
        return new EventoDto(salvo);
    }

    @GetMapping("/{id}")
    public EventoDto buscar(@PathVariable Long id) {
        Evento evento = eventoRepository.findById(id).orElseThrow();
        return new EventoDto(evento);
    }

    @PutMapping("/{id}")
    public EventoDto atualizar(@PathVariable Long id, @RequestBody Evento dados) {
        Evento evento = eventoRepository.findById(id).orElseThrow();
        evento.setNome(dados.getNome());
        evento.setDescricao(dados.getDescricao());
        evento.setData(dados.getData());

        Evento atualizado = eventoRepository.save(evento);
        return new EventoDto(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        eventoRepository.deleteById(id);
    }
}
