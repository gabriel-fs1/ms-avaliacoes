package br.ifsp.ms_avaliacoes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_atividade_texto")
public class AtividadeTexto extends Atividade {

    private Integer maximoCaracteres;
}
