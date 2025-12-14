package br.ifsp.ms_avaliacoes.dto.alternativa;

import lombok.Data;

@Data
public class AlternativaDto {
    private String texto;
    private Boolean correta;

    public AlternativaDto() {}

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getCorreta() {
        return correta;
    }
    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }
}
