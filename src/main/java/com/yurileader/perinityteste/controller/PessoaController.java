package com.yurileader.perinityteste.controller;

import com.yurileader.perinityteste.dto.PessoaDTO;
import com.yurileader.perinityteste.model.Pessoa;
import com.yurileader.perinityteste.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
