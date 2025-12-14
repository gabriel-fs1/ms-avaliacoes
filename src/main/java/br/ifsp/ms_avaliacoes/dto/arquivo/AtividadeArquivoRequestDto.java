package br.ifsp.ms_avaliacoes.dto.arquivo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeRequestDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class AtividadeArquivoRequestDto extends AtividadeRequestDto {

    private List<String> formatosPermitidos;
    private String tipoAtividade;
    private Long idTopico;

}
