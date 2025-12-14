package br.ifsp.ms_avaliacoes.dto.arquivo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

import br.ifsp.ms_avaliacoes.dto.atividade.AtividadeResponseDto;

@Data
@EqualsAndHashCode(callSuper = true)
public class AtividadeArquivoResponseDto extends AtividadeResponseDto {
    private List<String> formatosPermitidos;
    private Long idTopico;


    public AtividadeArquivoResponseDto() {

    }
}
