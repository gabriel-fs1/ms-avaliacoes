package br.ifsp.ms_avaliacoes.dto.arquivo;

import lombok.EqualsAndHashCode;

import java.util.List;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeUpdateDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class AtividadeArquivoUpdateDto extends AtividadeUpdateDto {
    private List<String> formatosPermitidos;


}
