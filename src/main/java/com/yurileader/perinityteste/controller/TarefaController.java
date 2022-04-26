package com.yurileader.perinityteste.controller;

import com.yurileader.perinityteste.dto.PessoaDTOInput;
import com.yurileader.perinityteste.dto.TarefaDTO;
import com.yurileader.perinityteste.service.TarefaService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO dto){
        TarefaDTO tarefaCriada = tarefaService.adicionarTarefa(dto);

        return ResponseEntity.ok(tarefaCriada);
    }

    @PutMapping("/alocar/{id}")
    public ResponseEntity<TarefaDTO> alocarPessoa(@PathVariable Long id, @RequestBody Long pessoaId){
        tarefaService.alocarPessoaEmTarefa(id, pessoaId);
        return ResponseEntity.ok().build();
    }
}
