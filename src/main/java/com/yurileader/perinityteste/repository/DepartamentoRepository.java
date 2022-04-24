package com.yurileader.perinityteste.repository;

import com.yurileader.perinityteste.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
