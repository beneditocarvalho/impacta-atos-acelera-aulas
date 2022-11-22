package br.com.javatos.cursos.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Endereco {

    private String rua;
    private Integer numero;
    private String complemento;
    private String cep;
    private String uf;
    private String cidade;

}
