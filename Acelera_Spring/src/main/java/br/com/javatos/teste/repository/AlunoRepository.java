package br.com.javatos.teste.repository;

import br.com.javatos.teste.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
