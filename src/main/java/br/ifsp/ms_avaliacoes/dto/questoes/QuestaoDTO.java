package br.ifsp.ms_avaliacoes.dto.questoes;

import lombok.Data;
import java.util.List;

import br.ifsp.ms_avaliacoes.dto.alternativa.AlternativaDto;

@Data
public class QuestaoDTO {
    private String enunciado;
    private List<AlternativaDto> alternativas;

    public QuestaoDTO() {}

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<AlternativaDto> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<AlternativaDto> alternativas) {
        this.alternativas = alternativas;
    }
}
