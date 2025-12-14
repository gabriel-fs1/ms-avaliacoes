package br.ifsp.ms_avaliacoes.dto.atividade;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AtividadeResponseDto {
    private Long id;
    private String titulo;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Boolean statusAtividade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(Boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

}
