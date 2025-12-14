package br.ifsp.ms_avaliacoes.dto.questionario;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeUpdateDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AtividadeQuestionarioUpdateDto extends AtividadeUpdateDto {

    private Integer duracaoMinutos;
    private Integer numeroTentativasPermitidas;

}
