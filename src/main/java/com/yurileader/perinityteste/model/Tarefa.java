package com.yurileader.perinityteste.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;

    @OneToOne(fetch = FetchType.LAZY)
    private Departamento departamento;
    private Long duracao;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaAlocada;
    private boolean finalizado;
}
