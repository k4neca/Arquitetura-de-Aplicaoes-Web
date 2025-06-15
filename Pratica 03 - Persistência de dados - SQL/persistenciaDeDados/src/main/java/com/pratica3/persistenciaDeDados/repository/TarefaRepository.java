package com.pratica3.persistenciaDeDados.repository;

import com.pratica3.persistenciaDeDados.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
