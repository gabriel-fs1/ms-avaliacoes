package br.ifsp.ms_avaliacoes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "tb_tentativa")
public class Tentativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraEntrega;

    private Double notaFinal;

    // Quem fez a prova? Apenas o ID!
    @Column(name = "id_aluno")
    private Long idAluno;

    @ManyToOne
    @JoinColumn(name = "questionario_id")
    @JsonIgnore
    private AtividadeQuestionario questionario;
}
