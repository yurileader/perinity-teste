package com.yurileader.perinityteste.service;

import com.yurileader.perinityteste.dto.PessoaDTO;
import com.yurileader.perinityteste.dto.PessoaDTOInput;
import com.yurileader.perinityteste.model.Pessoa;
import com.yurileader.perinityteste.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<PessoaDTO> listarTodos(){
        return pessoaRepository.listarPessoasHoras();
    }

    public Pessoa criarPessoa(PessoaDTOInput pessoaDTO) {
        Pessoa pessoa = toEntity(pessoaDTO);
        return pessoaRepository.save(pessoa);
    }


    private Pessoa toEntity(PessoaDTOInput dto){
        return modelMapper.map(dto, Pessoa.class);
    }

    public Pessoa atualizar(PessoaDTOInput pessoaDTO, Long id) {
        Pessoa pessoaSalva = buscarPEssoaPorId(id);
        BeanUtils.copyProperties(pessoaDTO, pessoaSalva);
        pessoaRepository.save(pessoaSalva);
        return  pessoaSalva;
    }

    public Pessoa buscarPEssoaPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public void excluir(Long id) {
        Pessoa pessoaSalva = buscarPEssoaPorId(id);
        if (ObjectUtils.anyNotNull(pessoaSalva) && pessoaSalva.getId() > 0){
            pessoaRepository.deleteById(id);
        }
    }
}
