package br.ifsp.ms_avaliacoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_alternativa")
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private Boolean correta; // Fundamental para corrigir a prova!

    @ManyToOne
    @JoinColumn(name = "questao_id")
    @JsonIgnore
    private Questao questao;
}
