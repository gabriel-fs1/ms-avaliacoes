package br.ifsp.ms_avaliacoes.controller;

import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoRequestDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoResponseDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoUpdateDto;
import br.ifsp.ms_avaliacoes.service.AtividadeTextoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades-texto")
public class AtividadeTextoController {

    @Autowired
    private AtividadeTextoService service;

    // 1. CREATE (POST) - Recebe RequestDto, Retorna ResponseDto
    @PostMapping
    public ResponseEntity<AtividadeTextoResponseDto> create(@RequestBody @Valid AtividadeTextoRequestDto dto) {
        return ResponseEntity.status(201).body(service.criar(dto));
    }

    // 2. READ (GET) - Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<AtividadeTextoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // 3. UPDATE (PUT/PATCH) - Recebe UpdateDto
    @PutMapping("/{id}")
    public ResponseEntity<AtividadeTextoResponseDto> update(@PathVariable Long id, @RequestBody AtividadeTextoUpdateDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // 4. DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }
}
