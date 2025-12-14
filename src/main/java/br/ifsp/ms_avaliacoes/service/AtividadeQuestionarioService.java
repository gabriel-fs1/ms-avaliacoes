package br.ifsp.ms_avaliacoes.service;

import br.ifsp.ms_avaliacoes.dto.alternativa.AlternativaDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioRequestDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioResponseDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioUpdateDto;
import br.ifsp.ms_avaliacoes.dto.questoes.QuestaoDTO;
import br.ifsp.ms_avaliacoes.dto.tentativa.TentativaInputDto;
import br.ifsp.ms_avaliacoes.model.*;
import br.ifsp.ms_avaliacoes.repository.AtividadeQuestionarioRepository;
import br.ifsp.ms_avaliacoes.repository.TentativaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtividadeQuestionarioService extends BaseAtividadeService {

    @Autowired
    private AtividadeQuestionarioRepository atividadeQuestionarioRepo;

    @Autowired
    private TentativaRepository tentativaRepository;

    @Transactional
    public AtividadeQuestionarioResponseDto criar(AtividadeQuestionarioRequestDto dto) {
        AtividadeQuestionario q = new AtividadeQuestionario();

        mapBaseRequest(q, dto);
        q.setDuracaoMinutos(dto.getDuracaoMinutos());
        q.setNumeroTentativasPermitidas(dto.getNumeroTentativasPermitidas());

        q.setQuestoes(mapQuestoesRequest(dto.getQuestoes(), q));

        q = atividadeQuestionarioRepo.save(q);
        return toResponse(q);
    }

    @Transactional
    public AtividadeQuestionarioResponseDto atualizar(Long id, AtividadeQuestionarioUpdateDto dto) {
        AtividadeQuestionario q = buscarEntidade(id);

        if (dto.getTitulo() != null)
            q.setTitulo(dto.getTitulo());
        if (dto.getDescricao() != null)
            q.setDescricao(dto.getDescricao());

        if (dto.getDataInicio() != null)
            q.setDataInicio(dto.getDataInicio());
        if (dto.getDataFechamento() != null)
            q.setDataFechamento(dto.getDataFechamento());

        if (dto.getStatusAtividade() != null)
            q.setStatusAtividade(dto.getStatusAtividade());

        if (dto.getDuracaoMinutos() != null)
            q.setDuracaoMinutos(dto.getDuracaoMinutos());
        if (dto.getNumeroTentativasPermitidas() != null)
            q.setNumeroTentativasPermitidas(dto.getNumeroTentativasPermitidas());

        q = atividadeQuestionarioRepo.save(q);
        return toResponse(q);
    }

    public AtividadeQuestionarioResponseDto buscarPorId(Long id) {
        AtividadeQuestionario entity = buscarEntidade(id);
        return toResponse(entity);
    }

    @Transactional
    public Tentativa realizarTentativa(Long idQuestionario, TentativaInputDto input) {
        AtividadeQuestionario questionario = buscarEntidade(idQuestionario);

        double acertos = 0;
        int totalQuestoes = (questionario.getQuestoes() != null) ? questionario.getQuestoes().size() : 0;

        if (input.getRespostas() != null) {
            for (TentativaInputDto.RespostaItemDto resposta : input.getRespostas()) {
                Questao questaoBanco = questionario.getQuestoes().stream()
                        .filter(q -> q.getId().equals(resposta.getIdQuestao()))
                        .findFirst().orElse(null);

                if (questaoBanco != null) {
                    boolean acertou = questaoBanco.getAlternativas().stream()
                            .anyMatch(alt -> alt.getId().equals(resposta.getIdAlternativaEscolhida())
                                    && Boolean.TRUE.equals(alt.getCorreta()));
                    if (acertou)
                        acertos++;
                }
            }
        }

        double notaFinal = (totalQuestoes > 0) ? (acertos / totalQuestoes) * 10.0 : 0.0;

        Tentativa tentativa = new Tentativa();
        tentativa.setQuestionario(questionario);
        tentativa.setIdAluno(input.getIdAluno());
        tentativa.setDataHoraEntrega(LocalDateTime.now());
        tentativa.setNotaFinal(notaFinal);

        return tentativaRepository.save(tentativa);
    }


    private AtividadeQuestionario buscarEntidade(Long id) {
        return atividadeQuestionarioRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Questionário não encontrado com id: " + id));
    }

    private AtividadeQuestionarioResponseDto toResponse(AtividadeQuestionario entity) {
        AtividadeQuestionarioResponseDto dto = new AtividadeQuestionarioResponseDto();
        fillBaseResponse(dto, entity);
        dto.setDuracaoMinutos(entity.getDuracaoMinutos());
        dto.setNumeroTentativasPermitidas(entity.getNumeroTentativasPermitidas());

        List<QuestaoDTO> questoesDto = mapQuestoesResponse(entity.getQuestoes());
        dto.setQuestoes(questoesDto);
        return dto;
    }

    private List<Questao> mapQuestoesRequest(List<QuestaoDTO> dtoQuestoes, AtividadeQuestionario questionario) {
        List<Questao> questoes = new ArrayList<>();
        if (dtoQuestoes != null) {
            for (QuestaoDTO qDto : dtoQuestoes) {
                Questao questao = new Questao();
                questao.setEnunciado(qDto.getEnunciado());
                questao.setQuestionario(questionario);

                List<Alternativa> alternativas = mapAlternativasRequest(qDto.getAlternativas(), questao);
                questao.setAlternativas(alternativas);
                questoes.add(questao);
            }
        }
        return questoes;
    }

    private List<Alternativa> mapAlternativasRequest(List<AlternativaDto> dtoAlternativas, Questao questao) {
        List<Alternativa> alternativas = new ArrayList<>();
        if (dtoAlternativas != null) {
            for (AlternativaDto aDto : dtoAlternativas) {
                Alternativa alt = new Alternativa();
                alt.setTexto(aDto.getTexto());
                alt.setCorreta(aDto.getCorreta());
                alt.setQuestao(questao);
                alternativas.add(alt);
            }
        }
        return alternativas;
    }

    private List<QuestaoDTO> mapQuestoesResponse(List<Questao> entityQuestoes) {
        List<QuestaoDTO> questoesDto = new ArrayList<>();
        if (entityQuestoes != null) {
            for (Questao q : entityQuestoes) {
                QuestaoDTO qDto = new QuestaoDTO();
                qDto.setEnunciado(q.getEnunciado());

                List<AlternativaDto> altsDto = mapAlternativasResponse(q.getAlternativas());
                qDto.setAlternativas(altsDto);
                questoesDto.add(qDto);
            }
        }
        return questoesDto;
    }

    private List<AlternativaDto> mapAlternativasResponse(List<Alternativa> entityAlternativas) {
        List<AlternativaDto> altsDto = new ArrayList<>();
        if (entityAlternativas != null) {
            for (Alternativa a : entityAlternativas) {
                AlternativaDto aDto = new AlternativaDto();
                aDto.setTexto(a.getTexto());
                aDto.setCorreta(a.getCorreta());
                altsDto.add(aDto);
            }
        }
        return altsDto;
    }
}
