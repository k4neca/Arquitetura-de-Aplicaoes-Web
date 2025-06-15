package com.pratica4.persistenciaDeDados.repository;

import com.pratica4.persistenciaDeDados.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {}
