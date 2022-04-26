package com.yurileader.perinityteste.repository;

import com.yurileader.perinityteste.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT t FROM Tarefa t WHERE t.pessoaAlocada.id = :id")
    Optional<List<Tarefa>> listarTarefasPorPessoaId(Long id);
}
