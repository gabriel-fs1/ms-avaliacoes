package br.ifsp.ms_avaliacoes.controller;

import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioRequestDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioResponseDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioUpdateDto;
import br.ifsp.ms_avaliacoes.dto.tentativa.TentativaInputDto;
import br.ifsp.ms_avaliacoes.model.Tentativa;
import br.ifsp.ms_avaliacoes.service.AtividadeQuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades-questionario")
public class AtividadeQuestionarioController {

    @Autowired
    private AtividadeQuestionarioService service;

    @PostMapping
    public ResponseEntity<AtividadeQuestionarioResponseDto> criar(@RequestBody AtividadeQuestionarioRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtividadeQuestionarioResponseDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtividadeQuestionarioResponseDto> atualizar(@PathVariable Long id, @RequestBody AtividadeQuestionarioUpdateDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletarAtividade(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/tentativas")
    public ResponseEntity<Tentativa> enviarTentativa(@PathVariable Long id, @RequestBody TentativaInputDto dto) {
        Tentativa tentativa = service.realizarTentativa(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tentativa);
    }
}
