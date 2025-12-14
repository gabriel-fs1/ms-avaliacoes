package br.ifsp.ms_avaliacoes.dto.atividade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.ifsp.ms_avaliacoes.dto.arquivo.AtividadeArquivoRequestDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioRequestDto;
import br.ifsp.ms_avaliacoes.dto.texto.AtividadeTextoRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoAtividade", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AtividadeTextoRequestDto.class, name = "TEXTO"),
        @JsonSubTypes.Type(value = AtividadeArquivoRequestDto.class, name = "ARQUIVO"),
        @JsonSubTypes.Type(value = AtividadeQuestionarioRequestDto.class, name = "QUESTIONARIO")

})
public class AtividadeRequestDto {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    private String descricao;

    @NotNull(message = "Data de início é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @NotNull(message = "Data de fechamento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    @NotNull(message = "O status da atividade (aberto ou fechado) é obrigatório")
    private Boolean statusAtividade;



    public Boolean getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(Boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
    }
}
