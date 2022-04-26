package com.yurileader.perinityteste.service;


import com.yurileader.perinityteste.dto.TarefaDTO;
import com.yurileader.perinityteste.exceptionhandler.exceptions.TarefaNaoPermitidaException;
import com.yurileader.perinityteste.model.Pessoa;
import com.yurileader.perinityteste.model.Tarefa;
import com.yurileader.perinityteste.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final PessoaService pessoaService;
    private final ModelMapper modelMapper;

    public TarefaDTO adicionarTarefa(TarefaDTO dto){
        Tarefa tarefa = toEntity(dto);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return toDTO(tarefaSalva);
    }

    public Tarefa toEntity(TarefaDTO dto){
        return modelMapper.map(dto, Tarefa.class);
    }

    public TarefaDTO toDTO (Tarefa tarefa){
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    public void alocarPessoaEmTarefa(Long id, Long pessoaId) {
        Pessoa pessoa = pessoaService.buscarPessoaPorId(pessoaId);
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

        if(pessoa.getDepartamento().getId() != tarefa.getDepartamento().getId()){
            throw new TarefaNaoPermitidaException("Não é possivel associar pessoa em tarefas com departamentos difetentes");
        }
        tarefa.setDepartamento(pessoa.getDepartamento());
        tarefaRepository.save(tarefa);
    }
}
