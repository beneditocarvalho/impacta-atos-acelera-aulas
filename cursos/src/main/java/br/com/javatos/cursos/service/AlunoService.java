package br.com.javatos.cursos.service;

import br.com.javatos.cursos.model.Aluno;
import br.com.javatos.cursos.model.Endereco;
import br.com.javatos.cursos.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final EnderecoService enderecoService;

    public Aluno salvar(Aluno aluno) {

        String cep = aluno.getEndereco().getCep();
        if (!ObjectUtils.isEmpty(cep)) {
            Endereco endereco = enderecoService.getEndereco(cep);
            aluno.getEndereco().setRua(endereco.getRua());
            aluno.getEndereco().setUf(endereco.getUf());
            aluno.getEndereco().setCidade(endereco.getCidade());
        }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno alterar(Aluno aluno) {
        Aluno alunoEntity = alunoRepository.findById(aluno.getId()).orElseThrow();
        alunoEntity.getCursos().get(0).setId(aluno.getId());
        alunoEntity.getNotas().get(0).setId(aluno.getId());

        return alunoRepository.save(alunoEntity);
    }
}
