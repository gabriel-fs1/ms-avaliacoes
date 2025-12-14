package br.ifsp.ms_avaliacoes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_atividade_questionario")
@PrimaryKeyJoinColumn(name = "id") // Usa o ID da tabela pai 'tb_atividade'
public class AtividadeQuestionario extends Atividade {

    // NÃO COLOCAMOS id, titulo, descricao AQUI. Eles vêm de 'Atividade'.

    private Integer duracaoMinutos;
    private Integer numeroTentativasPermitidas;

    // Relacionamento com as questões
    @OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes;
}
