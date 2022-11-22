package br.com.javatos.cadastro.exception.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponseError {
    private String error;

    public static RestResponseError pessoaNotFoundException(String mensagem){
        RestResponseError rest = new RestResponseError();
        rest.error = mensagem;
        return rest;
    }
}
