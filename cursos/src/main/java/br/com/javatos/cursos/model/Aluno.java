package br.com.javatos.cursos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ApiModel(value = "AlunoCDF", description = "classe modelo para um aluno")
@ApiIgnore
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(example = "Benedito Carvalho",required = true)
    private String nome;

    @ApiModelProperty(example = "01990132595465",required = true)
    private String cpf;

    @ApiModelProperty(example = "benedito@carvalho",required = true)
    private String email;

    @ApiModelProperty(example = "21321321")
    private String matricula;

    @Embedded
    private Endereco endereco;

    @ManyToMany
    @JsonIgnore
    private List<Curso> cursos = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Nota> notas = new ArrayList<>();

}
