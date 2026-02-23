package com.gudymaker.studiotasks.repository;

import com.gudymaker.studiotasks.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
        List<Tarefa> findAllByOrderByCompletedAscIdAsc();
}
