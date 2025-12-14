package br.ifsp.ms_avaliacoes.dto.texto;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AtividadeTextoResponseDto extends AtividadeResponseDto {
    private Integer maximoCaracteres;

    public AtividadeTextoResponseDto() {

    }
}
