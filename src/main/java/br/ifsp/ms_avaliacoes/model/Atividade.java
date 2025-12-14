package br.ifsp.ms_avaliacoes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_atividade")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFechamento;
    private Boolean statusAtividade;

    public void setStatusAtividade(Boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public Boolean getStatusAtividade() {
        return statusAtividade;
    }
}
