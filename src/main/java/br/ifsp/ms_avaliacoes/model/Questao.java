package br.ifsp.ms_avaliacoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "tb_questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "atividade_questionario_id")
    @JsonIgnore
    // MUDANÇA AQUI: Tipo alterado de Questionario para AtividadeQuestionario
    private AtividadeQuestionario questionario;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternativa> alternativas;
}
