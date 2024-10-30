package br.univille.microservproreitoriadeensino.criacao_cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservproreitoriadeensino.criacao_cursos.entity.Curso;
import br.univille.microservproreitoriadeensino.criacao_cursos.service.CursoService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoAPIController {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> get(){
        var listaCursos = service.getAll();

        return new ResponseEntity<List<Curso>>(listaCursos,HttpStatus.OK);
    }

    @PostMapping 
    public ResponseEntity<Curso> post (@RequestBody Curso curso) {
        if (curso == null) {
            return new ResponseEntity <>(HttpStatus.BAD_REQUEST);
        }
        var cursoSalvo = service.save(curso);

        return new ResponseEntity<Curso>(cursoSalvo, HttpStatus.OK);
    }

}