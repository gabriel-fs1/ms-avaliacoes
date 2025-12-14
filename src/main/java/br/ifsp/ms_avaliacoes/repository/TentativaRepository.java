package br.ifsp.ms_avaliacoes.repository;

import br.ifsp.ms_avaliacoes.model.Tentativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TentativaRepository extends JpaRepository<Tentativa, Long> {
}
