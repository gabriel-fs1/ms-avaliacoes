package br.ifsp.ms_avaliacoes.dto.texto;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeRequestDto;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AtividadeTextoRequestDto extends AtividadeRequestDto {

    @Positive(message = "O máximo de caracteres deve ser positivo")
    private Integer maximoCaracteres;
}
