package com.faculdade_ipog.gerenciador_tarefas.controller;

import com.faculdade_ipog.gerenciador_tarefas.model.Tarefa;
import com.faculdade_ipog.gerenciador_tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> obterTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarNova(@Valid @RequestBody Tarefa tarefa) {
        Tarefa criada = tarefaService.salvar(tarefa);
        return new ResponseEntity<>(criada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> alterarExistente(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaNova) {
        Tarefa atualizada = tarefaService.atualizar(id, tarefaNova);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarRegistrada(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}