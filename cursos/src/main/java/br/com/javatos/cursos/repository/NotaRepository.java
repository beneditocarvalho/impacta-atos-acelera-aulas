package br.com.javatos.cursos.repository;

import br.com.javatos.cursos.model.Aluno;
import br.com.javatos.cursos.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
