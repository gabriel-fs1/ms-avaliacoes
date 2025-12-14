package br.ifsp.ms_avaliacoes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_atividade_questionario")
@PrimaryKeyJoinColumn(name = "id")
public class AtividadeQuestionario extends Atividade {

    private Integer duracaoMinutos;
    private Integer numeroTentativasPermitidas;

    @OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes;
}
