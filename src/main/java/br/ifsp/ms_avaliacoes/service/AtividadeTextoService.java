package br.ifsp.ms_avaliacoes.service;

import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoRequestDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoResponseDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoUpdateDto;
import br.ifsp.ms_avaliacoes.model.AtividadeTexto;
import br.ifsp.ms_avaliacoes.repository.AtividadeTextoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeTextoService extends BaseAtividadeService {

    @Autowired
    private AtividadeTextoRepository textoRepo;

    @Transactional
    public AtividadeTextoResponseDto criar(AtividadeTextoRequestDto dto) {
        AtividadeTexto entity = new AtividadeTexto();
        mapBaseRequest(entity, dto);
        entity.setMaximoCaracteres(dto.getMaximoCaracteres());
        entity = textoRepo.save(entity);
        return toResponse(entity);
    }

    @Transactional
    public AtividadeTextoResponseDto atualizar(Long id, AtividadeTextoUpdateDto dto) {
        AtividadeTexto entity = textoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atividade Texto não encontrada com id: " + id));

        if (dto.getTitulo() != null)
            entity.setTitulo(dto.getTitulo());
        if (dto.getDescricao() != null)
            entity.setDescricao(dto.getDescricao());
        if (dto.getDataInicio() != null)
            entity.setDataInicio(dto.getDataInicio());
        if (dto.getDataFechamento() != null)
            entity.setDataFechamento(dto.getDataFechamento());
        if (dto.getMaximoCaracteres() != null)
            entity.setMaximoCaracteres(dto.getMaximoCaracteres());
        if (dto.getStatusAtividade() != null)
            entity.setStatusAtividade(dto.getStatusAtividade());

        entity = textoRepo.save(entity);
        return toResponse(entity);
    }

    public AtividadeTextoResponseDto buscarPorId(Long id) {
        AtividadeTexto entity = textoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atividade Texto não encontrada"));
        return toResponse(entity);
    }

    private AtividadeTextoResponseDto toResponse(AtividadeTexto entity) {
        AtividadeTextoResponseDto dto = new AtividadeTextoResponseDto();
        fillBaseResponse(dto, entity);
        dto.setMaximoCaracteres(entity.getMaximoCaracteres());
        return dto;
    }
}
