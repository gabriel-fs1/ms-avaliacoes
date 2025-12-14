package br.ifsp.ms_avaliacoes.dto.tentativa;

import lombok.Data;
import java.util.List;

@Data
public class TentativaInputDto {
    private Long idAluno;
    private List<RespostaItemDto> respostas;

    @Data
    public static class RespostaItemDto {
        private Long idQuestao;
        private Long idAlternativaEscolhida;
    }
}
