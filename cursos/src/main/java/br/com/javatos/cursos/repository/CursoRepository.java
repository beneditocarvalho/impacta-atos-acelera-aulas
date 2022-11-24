package br.com.javatos.cursos.repository;

import br.com.javatos.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
