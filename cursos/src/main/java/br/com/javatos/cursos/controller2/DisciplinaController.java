package br.com.javatos.cursos.controller2;

import br.com.javatos.cursos.model.Disciplina;
import br.com.javatos.cursos.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    private final DisciplinaService disciplinaService;

    @PostMapping
    public Disciplina salvar(@RequestBody Disciplina disciplina){

        return disciplinaService.salvar(disciplina);

        //TODO
        // ok receber uma Disciplina
        // validar a Disciplina
        // ok salvar no BD
        // retornar ou não a disciplina salva
    }

    @GetMapping
    public List<Disciplina> listarTodas( ) {
        return disciplinaService.listarTodos();
    }
}
