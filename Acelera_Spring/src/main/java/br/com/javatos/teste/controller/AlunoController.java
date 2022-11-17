package br.com.javatos.teste.controller;

import br.com.javatos.teste.model.Aluno;
import br.com.javatos.teste.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @Autowired
    public AlunoService alunoService;

    @PostMapping("/aluno")
    public Aluno salvar (@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }
}
