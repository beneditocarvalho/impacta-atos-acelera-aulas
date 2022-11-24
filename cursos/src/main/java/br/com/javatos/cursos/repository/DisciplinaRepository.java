package br.com.javatos.cursos.repository;

import br.com.javatos.cursos.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
