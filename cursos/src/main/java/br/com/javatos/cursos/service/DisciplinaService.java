package br.com.javatos.cursos.service;

import br.com.javatos.cursos.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;


}
