package br.ifsp.ms_avaliacoes.dto.questionario;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeResponseDto;
import br.ifsp.ms_avaliacoes.dto.questoes.QuestaoDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class AtividadeQuestionarioResponseDto extends AtividadeResponseDto {

    private Integer duracaoMinutos;
    private Integer numeroTentativasPermitidas;

    // O Response retorna a estrutura completa das questões
    private List<QuestaoDTO> questoes;

    public AtividadeQuestionarioResponseDto() {
    }
}
