package com.faculdade_ipog.gerenciador_tarefas.controller;


import com.faculdade_ipog.gerenciador_tarefas.model.Tarefa;
import com.faculdade_ipog.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> findAll(){
        return tarefaRepository.findAll();
    }

    @PostMapping
    public Tarefa Criar(@RequestBody Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa Atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        // Buscamos a tarefa existente no banco. Se não achar, lança um erro.
        return tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setConcluida(tarefaAtualizada.isConcluida());
            return tarefaRepository.save(tarefaExistente);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o id: " + id));
    }

    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id){
        tarefaRepository.deleteById(id);
    }
}
