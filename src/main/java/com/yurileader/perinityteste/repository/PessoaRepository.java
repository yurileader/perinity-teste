package com.yurileader.perinityteste.repository;

import com.yurileader.perinityteste.dto.PessoaDTO;
import com.yurileader.perinityteste.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT new PessoaDTO(p.nome as nome, d.titulo as departamento, t.duracao as totalHoras) " +
            "FROM Pessoa p JOIN FETCH Tarefa t ON t.pessoaAlocada.id = p.id " +
            "JOIN FETCH Departamento d ON d.id = p.departamento.id" )
    List<PessoaDTO> listarPessoasHoras();


}
