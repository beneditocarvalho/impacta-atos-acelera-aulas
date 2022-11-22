package br.com.javatos.cadastro.exception.config;

public class DuplicacaoCadastroException extends RuntimeException{
    public DuplicacaoCadastroException(String message){
        super(message);
    }
}
