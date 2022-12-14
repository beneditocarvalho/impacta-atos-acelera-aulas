package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Nota;
import br.com.javatos.cursos.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NotaController {

    @Autowired
    private final NotaService notaService;

    @PostMapping
    public Nota salvar(@RequestBody Nota nota){

        return notaService.salvar(nota);


    }

    @GetMapping
    public List<Nota> listarTodas( ) {
        return notaService.listarTodas();
    }
}
