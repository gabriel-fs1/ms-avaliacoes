package br.ifsp.ms_avaliacoes.dto.texto;


import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeUpdateDto;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;


@Getter // Use @Getter e @Setter em vez de @Data
@Setter
@EqualsAndHashCode(callSuper = true)
public class AtividadeTextoUpdateDto extends AtividadeUpdateDto {
    private Integer maximoCaracteres;

}
