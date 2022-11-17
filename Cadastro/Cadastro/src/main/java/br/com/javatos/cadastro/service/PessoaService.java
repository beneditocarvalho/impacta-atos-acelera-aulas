package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;


    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
}
