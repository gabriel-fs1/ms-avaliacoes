package br.ifsp.ms_avaliacoes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tb_atividade_arquivo")
public class AtividadeArquivo extends Atividade {

    @ElementCollection // Cria tabela auxiliar para lista simples
    @CollectionTable(name = "tb_formatos_arquivo", joinColumns = @JoinColumn(name = "atividade_id"))
    @Column(name = "formato")
    private List<String> formatosPermitidos;
    private Long idTopico;
}
