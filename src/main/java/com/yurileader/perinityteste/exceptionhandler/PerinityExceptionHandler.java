package com.yurileader.perinityteste.exceptionhandler;

import com.yurileader.perinityteste.exceptionhandler.exceptions.PessoaNaoEncontradaOuNaoExisteException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PerinityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PessoaNaoEncontradaOuNaoExisteException.class})
    protected ResponseEntity<Object> handlePessoaNaoEncontradaOuNaoExisteExceptionException(PessoaNaoEncontradaOuNaoExisteException ex, WebRequest request) {
        var mensagemDesenvolvedor = ex.toString();
        return handleExceptionInternal(ex, mensagemDesenvolvedor, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
