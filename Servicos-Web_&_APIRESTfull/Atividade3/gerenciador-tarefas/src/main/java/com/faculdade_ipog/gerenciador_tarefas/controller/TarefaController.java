package com.faculdade_ipog.gerenciador_tarefas.controller;


import com.faculdade_ipog.gerenciador_tarefas.model.Tarefa;
import com.faculdade_ipog.gerenciador_tarefas.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.faculdade_ipog.gerenciador_tarefas.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll() {
        return ResponseEntity.ok(tarefaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Tarefa> save(@Valid @RequestBody Tarefa tarefa) {
        Tarefa salva = tarefaRepository.save(tarefa);
        return new ResponseEntity<>(salva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaNova) {
        Tarefa atualizada = tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTitulo(tarefaNova.getTitulo());
            tarefaExistente.setDescricao(tarefaNova.getDescricao());
            tarefaExistente.setConcluida(tarefaNova.isConcluida());
            return tarefaRepository.save(tarefaExistente);
        }).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o ID: " + id));

        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Impossível deletar. Tarefa não encontrada com o ID: " + id);
        }
        tarefaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
