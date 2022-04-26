package com.yurileader.perinityteste.service;

import com.yurileader.perinityteste.dto.PessoaDTO;
import com.yurileader.perinityteste.dto.PessoaDTOInput;
import com.yurileader.perinityteste.dto.PessoaVO;
import com.yurileader.perinityteste.exceptionhandler.exceptions.DepartamentoNaoEncontrado;
import com.yurileader.perinityteste.exceptionhandler.exceptions.PessoaNaoEncontradaOuNaoExisteException;
import com.yurileader.perinityteste.model.Departamento;
import com.yurileader.perinityteste.model.Pessoa;
import com.yurileader.perinityteste.model.Tarefa;
import com.yurileader.perinityteste.repository.DepartamentoRepository;
import com.yurileader.perinityteste.repository.PessoaRepository;
import com.yurileader.perinityteste.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final TarefaRepository tarefaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<PessoaDTO> listarTodos(){
        return pessoaRepository.listarPessoasHoras();
    }

    public Pessoa criarPessoa(PessoaDTOInput pessoaDTO) {
        Pessoa pessoa = toEntity(pessoaDTO);
        return pessoaRepository.save(pessoa);
    }

    public PessoaVO atualizar(PessoaDTOInput pessoaDTO, Long id) {
        Pessoa pessoaCarregada = buscarPessoaPorId(id);
        Departamento departamento = departamentoRepository.findById(pessoaDTO.getDepartamento())
                .orElseThrow(() -> new DepartamentoNaoEncontrado("Departamento não encontrado ou não existente"));
        pessoaCarregada.setDepartamento(departamento);
        BeanUtils.copyProperties(pessoaDTO, pessoaCarregada);

        Pessoa pessoaSalva = pessoaRepository.save(pessoaCarregada);

        PessoaVO pessoaVO = toVO(pessoaSalva);
        return  pessoaVO;
    }

    public Pessoa buscarPessoaPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaOuNaoExisteException("Pessoa não encontrada / não existe"));
    }

    public void excluir(Long id) {
        Pessoa pessoaSalva = buscarPessoaPorId(id);
        List<Tarefa> tarefas = tarefaRepository.listarTarefasPorPessoaId(id).orElse( new ArrayList<>());
        if (isExistePessoa(pessoaSalva) && !tarefas.isEmpty()){
            tarefas.forEach((tarefa) -> tarefaRepository.deleteById(tarefa.getId()) );
            pessoaRepository.deleteByIdAndDepartamento_Id(id, pessoaSalva.getDepartamento().getId());
        }
    }

    private boolean isExistePessoa(Pessoa pessoaSalva) {
        return ObjectUtils.anyNotNull(pessoaSalva) && pessoaSalva.getId() > 0;
    }

    @Transactional(readOnly = true)
    public PessoaVO buscarPessoaPorNome(String nome) {
       Pessoa pessoaCarregada = pessoaRepository.findByNome(nome)
               .orElseThrow(() -> new PessoaNaoEncontradaOuNaoExisteException("Pessoa Não encontrada"));
        PessoaVO pessoaDTO = toVO(pessoaCarregada);
        return pessoaDTO;
    }

    public Pessoa toEntity(PessoaDTOInput dto){
        return modelMapper.map(dto, Pessoa.class);
    }
    public PessoaVO toVO(Pessoa pessoa){ return modelMapper.map(pessoa, PessoaVO.class);
    }
}
