package br.com.javatos.cadastro.exception.erros;

public class DuplicacaoCadastroException extends RuntimeException{
    public DuplicacaoCadastroException(String message){
        super(message);
    }
}
