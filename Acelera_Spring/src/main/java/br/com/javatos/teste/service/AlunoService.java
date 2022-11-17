package br.com.javatos.teste.service;

import br.com.javatos.teste.model.Aluno;
import br.com.javatos.teste.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

}
