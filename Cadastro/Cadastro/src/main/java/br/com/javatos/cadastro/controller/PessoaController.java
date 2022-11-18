package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public Pessoa salvar (@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> buscarTodos(){
        return pessoaService.bucarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id){
        return pessoaService.buscar(id);
    }

    @GetMapping("/cpf/{cpf}")
    public Pessoa buscarPorCpf(@PathVariable String cpf){
        return pessoaService.buscarPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    public void apagar(Pessoa pessoa){
        pessoaService.apagar(pessoa);
    }

    @DeleteMapping("/cpf/{cpf}")
    @Transactional
    public void apagarPorCpf(@PathVariable String cpf){
        pessoaService.apagarPorCpf(cpf);
    }
}
