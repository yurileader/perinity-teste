package com.yurileader.perinityteste.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTOInput {

    private String nome;
    private Long departamento;
}
