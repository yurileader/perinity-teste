package com.yurileader.perinityteste.service;

import com.yurileader.perinityteste.dto.PessoaDTO;
import com.yurileader.perinityteste.model.Pessoa;
import com.yurileader.perinityteste.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<PessoaDTO> listarTodos(){
        return pessoaRepository.listarPessoasHoras();
    }
}
