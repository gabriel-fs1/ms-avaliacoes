package br.ifsp.ms_avaliacoes.dto.questionario;

import lombok.Data;
import java.util.List;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeRequestDto;
import br.ifsp.ms_avaliacoes.dto.questoes.QuestaoDTO;

@Data
public class AtividadeQuestionarioRequestDto extends AtividadeRequestDto{
    private Integer duracaoMinutos;
    private Integer numeroTentativasPermitidas;

    private List<QuestaoDTO> questoes;

    public List<QuestaoDTO> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoDTO> questoes) {
        this.questoes = questoes;
    }
}
