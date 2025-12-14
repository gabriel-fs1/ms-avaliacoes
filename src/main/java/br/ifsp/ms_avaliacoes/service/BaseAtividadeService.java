package br.ifsp.ms_avaliacoes.service;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeRequestDto;
import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeResponseDto;
import br.ifsp.ms_avaliacoes.model.Atividade;
import br.ifsp.ms_avaliacoes.repository.AtividadeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseAtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    protected void mapBaseRequest(Atividade entity, AtividadeRequestDto dto) {
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFechamento(dto.getDataFechamento());
        entity.setStatusAtividade(dto.getStatusAtividade());

    }

    protected void fillBaseResponse(AtividadeResponseDto dto, Atividade entity) {
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setDescricao(entity.getDescricao());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFechamento(entity.getDataFechamento());
        dto.setStatusAtividade(entity.getStatusAtividade());
    }

    @Transactional
    public void deletarAtividade(Long id) {
        if (!atividadeRepository.existsById(id)) {
            throw new EntityNotFoundException("Atividade não encontrada para deleção");
        }
        atividadeRepository.deleteById(id);
    }
}
