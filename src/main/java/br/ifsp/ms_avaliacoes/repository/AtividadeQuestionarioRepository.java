package br.ifsp.ms_avaliacoes.repository;

import br.ifsp.ms_avaliacoes.model.AtividadeQuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeQuestionarioRepository extends JpaRepository<AtividadeQuestionario, Long> {
}
