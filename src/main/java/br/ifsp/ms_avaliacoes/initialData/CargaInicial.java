package br.ifsp.ms_avaliacoes.initialData;

import br.ifsp.ms_avaliacoes.dto.alternativa.AlternativaDto;
import br.ifsp.ms_avaliacoes.dto.questionario.AtividadeQuestionarioRequestDto;
import br.ifsp.ms_avaliacoes.dto.questoes.QuestaoDTO;
import br.ifsp.ms_avaliacoes.service.AtividadeQuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CargaInicial implements CommandLineRunner {

    @Autowired
    private AtividadeQuestionarioService questionarioService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Carga Inicial do Microsserviço de Avaliações ---");

        AtividadeQuestionarioRequestDto provaJava = new AtividadeQuestionarioRequestDto();

        provaJava.setTitulo("Prova de Java Básico");
        provaJava.setDescricao("Conceitos de Orientação a Objetos e Sintaxe.");

        provaJava.setDataInicio(LocalDate.of(2025, 12, 15));
        provaJava.setDataFechamento(LocalDate.of(2025, 12, 20));

        provaJava.setStatusAtividade(true);

        provaJava.setDuracaoMinutos(60);
        provaJava.setNumeroTentativasPermitidas(2);

        // Questão 1
        QuestaoDTO q1 = new QuestaoDTO();
        q1.setEnunciado("Qual a saída de 2 + 2 em Java?");

        AlternativaDto a1 = new AlternativaDto(); a1.setTexto("3"); a1.setCorreta(false);
        AlternativaDto a2 = new AlternativaDto(); a2.setTexto("4"); a2.setCorreta(true);
        AlternativaDto a3 = new AlternativaDto(); a3.setTexto("5"); a3.setCorreta(false);
        q1.setAlternativas(List.of(a1, a2, a3));

        provaJava.setQuestoes(List.of(q1));

        questionarioService.criar(provaJava);
        System.out.println("--- Prova Criada com Sucesso no H2 ---");
    }
}
