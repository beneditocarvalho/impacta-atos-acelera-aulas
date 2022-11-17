package br.com.javatos.cadastro.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_Pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "v_nome_completo", length = 300, nullable = false)
    private String nome;

    @Column(name = "v_email", length = 200, nullable = false)
    private String email;

    @Column(name = "v_cpf", length = 11, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String dataDeNascimento;

}
