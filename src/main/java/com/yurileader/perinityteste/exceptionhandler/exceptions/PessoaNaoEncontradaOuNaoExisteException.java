package com.yurileader.perinityteste.exceptionhandler.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PessoaNaoEncontradaOuNaoExisteException extends RuntimeException{

    public PessoaNaoEncontradaOuNaoExisteException(String message) {
        super(message);
    }
}
