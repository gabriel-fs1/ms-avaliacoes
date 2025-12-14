package br.ifsp.ms_avaliacoes.controller;

import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoRequestDto;
import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoResponseDto;
import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoUpdateDto;
import br.ifsp.ms_avaliacoes.service.AtividadeArquivoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades-arquivo")
public class AtividadeArquivoController {

    @Autowired
    private AtividadeArquivoService service;

    @PostMapping
    public ResponseEntity<AtividadeArquivoResponseDto> create(@RequestBody @Valid AtividadeArquivoRequestDto dto) {
        return ResponseEntity.status(201).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeArquivoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeArquivoResponseDto> update(@PathVariable Long id, @RequestBody AtividadeArquivoUpdateDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}
