package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;


    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> bucarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscar(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).orElse(null);
    }

    public void apagar(Pessoa pessoa){
        pessoaRepository.delete(pessoa);
    }

    public void apagarPorCpf(String cpf){
        pessoaRepository.deleteByCpf(cpf);
    }
}
