package br.ifsp.ms_avaliacoes.service;

import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoRequestDto;
import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoResponseDto;
import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoUpdateDto;
import br.ifsp.ms_avaliacoes.model.AtividadeArquivo;
import br.ifsp.ms_avaliacoes.repository.AtividadeArquivoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeArquivoService extends BaseAtividadeService {

    @Autowired
    private AtividadeArquivoRepository arquivoRepo;

    @Transactional
    public AtividadeArquivoResponseDto criar(AtividadeArquivoRequestDto dto) {
        AtividadeArquivo entity = new AtividadeArquivo();
        mapBaseRequest(entity, dto);
        entity.setFormatosPermitidos(dto.getFormatosPermitidos());
        if (dto.getIdTopico() != null) {
            entity.setIdTopico(dto.getIdTopico());
        }
        entity = arquivoRepo.save(entity);
        return toResponse(entity);
    }

    @Transactional
    public AtividadeArquivoResponseDto atualizar(Long id, AtividadeArquivoUpdateDto dto) {
        AtividadeArquivo entity = arquivoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atividade Arquivo não encontrada com id: " + id));

        if (dto.getTitulo() != null)
            entity.setTitulo(dto.getTitulo());
        if (dto.getDescricao() != null)
            entity.setDescricao(dto.getDescricao());
        if (dto.getDataInicio() != null)
            entity.setDataInicio(dto.getDataInicio());
        if (dto.getDataFechamento() != null)
            entity.setDataFechamento(dto.getDataFechamento());
        if (dto.getFormatosPermitidos() != null)
            entity.setFormatosPermitidos(dto.getFormatosPermitidos());

        entity = arquivoRepo.save(entity);
        return toResponse(entity);
    }

    public AtividadeArquivoResponseDto buscarPorId(Long id) {
        AtividadeArquivo entity = arquivoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atividade Arquivo não encontrada"));
        return toResponse(entity);
    }

    private AtividadeArquivoResponseDto toResponse(AtividadeArquivo entity) {
        AtividadeArquivoResponseDto dto = new AtividadeArquivoResponseDto();
        fillBaseResponse(dto, entity);
        dto.setFormatosPermitidos(entity.getFormatosPermitidos());
        dto.setIdTopico(entity.getIdTopico());
        return dto;
    }
}
