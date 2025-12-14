package br.ifsp.ms_avaliacoes.dto.atividade;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter // Use @Getter e @Setter em vez de @Data
@Setter
public class AtividadeUpdateDto {
    private String titulo;
    private String descricao;
    private Boolean statusAtividade;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
}
