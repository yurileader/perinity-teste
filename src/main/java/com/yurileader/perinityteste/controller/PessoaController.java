package com.yurileader.perinityteste.controller;

import com.yurileader.perinityteste.dto.PessoaDTO;
import com.yurileader.perinityteste.dto.PessoaDTOInput;
import com.yurileader.perinityteste.dto.PessoaVO;
import com.yurileader.perinityteste.model.Pessoa;
import com.yurileader.perinityteste.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> listarPessoas(){
        return pessoaService.listarTodos();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<PessoaVO> listarPessoaNome(@PathVariable String nome){

        PessoaVO pessoaSalva = pessoaService.buscarPessoaPorNome(nome);
        return ResponseEntity.ok(pessoaSalva);
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTOInput pessoaDTO){
        Pessoa pessoaSalva = pessoaService.criarPessoa(pessoaDTO);
        return ResponseEntity.ok().body(pessoaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaVO> atualizarPessoa(@RequestBody PessoaDTOInput pessoaDTO,@PathVariable Long id){
        PessoaVO pessoaAtualizada = pessoaService.atualizar(pessoaDTO, id);
        return ResponseEntity.ok().body(pessoaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaDTOInput> removerPessoa(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
