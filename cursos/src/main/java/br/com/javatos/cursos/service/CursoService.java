package br.com.javatos.cursos.service;


import br.com.javatos.cursos.model.Curso;
import br.com.javatos.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }
}
