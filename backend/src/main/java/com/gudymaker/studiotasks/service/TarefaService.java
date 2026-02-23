package com.gudymaker.studiotasks.service;

import com.gudymaker.studiotasks.model.Tarefa;
import com.gudymaker.studiotasks.repository.TarefaRepository;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //define o comportamento da class de processar dados
public class TarefaService
{
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefaRepository.findAllByOrderByCompletedAscIdAsc();
    }

    public Optional<Tarefa> buscarPorId(Long id){

        return tarefaRepository.findById(id);
    }

    public void deletar(Long id) {
        tarefaRepository.deleteById(id);
    }

}

