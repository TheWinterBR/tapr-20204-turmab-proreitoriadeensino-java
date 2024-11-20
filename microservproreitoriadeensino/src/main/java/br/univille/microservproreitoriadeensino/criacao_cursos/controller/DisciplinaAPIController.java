package br.univille.microservproreitoriadeensino.criacao_cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservproreitoriadeensino.criacao_cursos.entity.Disciplina;
import br.univille.microservproreitoriadeensino.criacao_cursos.service.DisciplinaService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplina")
public class DisciplinaAPIController {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<Disciplina>> get(){
        var listaDisciplinas = service.getAll();

        return new ResponseEntity<List<Disciplina>>(listaDisciplinas,HttpStatus.OK);
    }

    @PostMapping 
    public ResponseEntity<Disciplinas> post (@RequestBody Disciplina disciplina) {
        if (disciplina == null) {
            return new ResponseEntity <>(HttpStatus.BAD_REQUEST);
        }
        var disciplinaSalvo = service.save(disciplina);

        return new ResponseEntity<Curso>(disciplinaSalvo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> put(@PathVariable("id") String id, @RequestBody Disciplina disciplina) {
        if (disciplina == null | id == "" | id == null){
            return new ResponseEntity <>(HttpStatus.BAD_REQUEST);
        }
        disciplina = service.update(id, disciplina);
        if (disciplina == null) {
            return new ResponseEntity <>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Curso>(disciplina, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> 
        delete(@PathVariable("id") String id){
        if(id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var disciplina = service.delete(id);
        if(disciplina != null){
            return new ResponseEntity<Curso>(disciplina, HttpStatus.OK);
        }
        return new ResponseEntity<Curso>(disciplina, HttpStatus.NOT_FOUND);
    }

}
