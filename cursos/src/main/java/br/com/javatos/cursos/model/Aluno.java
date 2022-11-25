package br.com.javatos.cursos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(min = 2, max = 50)
    private String nome;

    @ApiModelProperty(example = "01990132595465",required = true)
    @CPF
    private String cpf;

    @ApiModelProperty(example = "benedito@carvalho",required = true)
    @Column(unique = true,length = 200)
    private String email;

    @ApiModelProperty(example = "21321321")
    private String matricula;

    @Embedded
    @ApiModelProperty(required = true)
    private Endereco endereco;

    @ManyToMany
    @JsonIgnore
    private List<Curso> cursos = new ArrayList<>();

    @ManyToMany
    @JsonIgnore
    private List<Nota> notas = new ArrayList<>();

}
