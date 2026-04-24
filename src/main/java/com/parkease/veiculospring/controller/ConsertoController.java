package com.parkease.veiculospring.controller;

import com.parkease.veiculospring.conserto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemConserto> cadastrar(
            @RequestBody @Valid DadosCadastroConserto dados,
            UriComponentsBuilder uriBuilder) {
        var conserto = repository.save(new Conserto(dados));
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemConserto(conserto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConserto>> listarTodos(Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemConserto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DadosDetalhamentoConserto>> listarResumo() {
        var lista = repository.findAllByAtivoTrue()
                .stream()
                .map(DadosDetalhamentoConserto::new)
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemConserto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(c -> ResponseEntity.ok(new DadosListagemConserto(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemConserto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoConserto dados) {
        var conserto = repository.getReferenceById(id);
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
