package com.yurileader.perinityteste.model;

import com.yurileader.perinityteste.dto.PessoaDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Departamento departamento;
    @OneToMany
    @JoinColumn(name = "pessoa_id")
    private List<Tarefa> tarefas;

}
