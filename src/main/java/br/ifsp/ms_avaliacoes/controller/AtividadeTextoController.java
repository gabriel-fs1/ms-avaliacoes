package br.ifsp.ms_avaliacoes.controller;

import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoRequestDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoResponseDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoUpdateDto;
import br.ifsp.ms_avaliacoes.service.AtividadeTextoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/atividades-texto")
public class AtividadeTextoController {
    private static final Logger log = LoggerFactory.getLogger(AtividadeTextoController.class);
    @Autowired
    private AtividadeTextoService service;

    @PostMapping
    public ResponseEntity<AtividadeTextoResponseDto> create(@RequestBody @Valid AtividadeTextoRequestDto dto) {
        log.info(">>>> MS AVALIAÇÕES: Recebida requisição POST para criar Atividade Texto. Título: {}",
                dto.getTitulo());

        AtividadeTextoResponseDto response = service.criar(dto);

        log.info("<<<< MS AVALIAÇÕES: Atividade Texto criada com sucesso. ID: {}", response.getId());
        return ResponseEntity.status(201).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeTextoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeTextoResponseDto> update(@PathVariable Long id,
            @RequestBody AtividadeTextoUpdateDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}
