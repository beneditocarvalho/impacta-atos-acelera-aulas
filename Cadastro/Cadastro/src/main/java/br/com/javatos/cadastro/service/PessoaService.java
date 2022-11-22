package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.exception.erros.DuplicacaoCadastroException;
import br.com.javatos.cadastro.exception.erros.PessoaExceptionNotFound;
import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Async
    public Pessoa salvar(Pessoa pessoa){
        log.info("persistindo o objeto");
        existeCpfOuEmail(pessoa); // possivelmente lança uma exception
        // esperar 30s
        Pessoa pessoaModel = pessoaRepository.save(pessoa);
        log.info("Objeto salvo {}:", pessoaModel);
        return pessoaModel;
    }

    public List<Pessoa> buscarTodos() {
        log.info("buscando a lista de pessoas no banco de dados");
        return pessoaRepository.findAll();
    }

    public Pessoa buscar(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaExceptionNotFound("ID não localizado"));
    }

        public ResponseEntity<Pessoa> buscarPorCpf(String cpf) {
            try {
                Optional<Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
                if (pessoa.isEmpty()) {
                    throw new PessoaExceptionNotFound("Não foi possível localizar o CPF");
                }
                return ResponseEntity.ok(pessoa.get()); // status code 200 com um body
            } catch (RuntimeException e) {
                log.error("erro na colsulta {}", e);
            }
            return ResponseEntity.internalServerError().build(); // status code 500
    }

    public void apagar(Long id){
        try {
            pessoaRepository.deleteById(id);
            log.warn("Excluindo uma pessoa");
        } catch (RuntimeException e) {
            throw new PessoaExceptionNotFound("ID não localizado");
        }
    }

    public void apagarPorCpf(String cpf) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
        if (pessoa.isEmpty()) {
            throw new PessoaExceptionNotFound("Não foi possível a exclusão por CPF");
        }
            pessoaRepository.deleteByCpf(cpf);
            log.warn("Excluindo uma pessoa");
    }


    private void existeCpfOuEmail(Pessoa pessoa) {
        Optional<Pessoa> pessoaEntidadeCpf = pessoaRepository.findByCpf(pessoa.getCpf());
        Optional<Pessoa> pessoaEntidadeEmail = pessoaRepository.findByEmail(pessoa.getEmail());
        if (pessoaEntidadeEmail.isPresent()) {
            throw new DuplicacaoCadastroException("email já cadastrado");
        }
        if (pessoaEntidadeCpf.isPresent()) {
            throw new DuplicacaoCadastroException("cpf já cadastrado");
        }
    }
}
