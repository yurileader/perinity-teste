package com.yurileader.perinityteste.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaVO {
     private Long id;
     private String nome;
     private DepartamentoDTO departamento;
}
