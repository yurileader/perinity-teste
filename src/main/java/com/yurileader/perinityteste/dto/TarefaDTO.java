package com.yurileader.perinityteste.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private DepartamentoDTO departamento;
    private Long duracao;
    private PessoaDTO pessoaAlocada;
    private boolean finalizado;
}
