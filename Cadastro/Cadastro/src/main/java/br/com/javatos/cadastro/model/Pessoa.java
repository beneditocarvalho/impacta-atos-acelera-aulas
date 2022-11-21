package br.com.javatos.cadastro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_Pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "v_nome_completo", length = 300, nullable = false)
    @NotBlank(message = "Campo não pode ser nulo")
    @Size(min = 2, max = 300, message = "Nome inválido")
    private String nome;

    @Column(name = "v_email", length = 200, nullable = false, unique = true)
    @Email(message = "E-mail informado inválido")
    private String email;

    @Column(name = "v_cpf", length = 11, nullable = false, unique = true)
    @CPF(message = "CPF informado inválido")
    private String cpf;

    @Column(nullable = false)
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataDeNascimento;

    @Column(nullable = false, unique = true, updatable = false)
    private String matricula = UUID.randomUUID().toString();

}
