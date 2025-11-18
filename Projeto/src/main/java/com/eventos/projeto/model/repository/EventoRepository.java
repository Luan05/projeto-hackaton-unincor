package com.eventos.projeto.model.repository;
import com.eventos.projeto.model.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
