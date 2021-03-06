package com.yurileader.perinityteste.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yurileader.perinityteste.model.Departamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PessoaDTO {
     @Id
     private String nome;
     private String departamento;
     private Long totalHoras;
}
