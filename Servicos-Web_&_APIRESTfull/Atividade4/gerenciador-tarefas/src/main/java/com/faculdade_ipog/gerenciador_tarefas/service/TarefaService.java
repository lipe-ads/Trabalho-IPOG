package com.faculdade_ipog.gerenciador_tarefas.service;

import com.faculdade_ipog.gerenciador_tarefas.exception.ResourceNotFoundException;
import com.faculdade_ipog.gerenciador_tarefas.model.Tarefa;
import com.faculdade_ipog.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa tarefaNova) {
        return tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaNova.getTitulo());
            tarefaExistente.setDescricao(tarefaNova.getDescricao());
            tarefaExistente.setConcluida(tarefaNova.isConcluida());
            return tarefaRepository.save(tarefaExistente);
        }).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o ID: " + id));
    }

    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Impossível deletar. Tarefa não encontrada com o ID: " + id);
        }
        tarefaRepository.deleteById(id);
    }
}