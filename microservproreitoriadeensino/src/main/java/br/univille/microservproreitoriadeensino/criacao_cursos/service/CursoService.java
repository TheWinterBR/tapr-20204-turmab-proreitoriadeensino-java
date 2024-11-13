package br.univille.microservproreitoriadeensino.criacao_cursos.service;
import java.util.List;

import br.univille.microservproreitoriadeensino.criacao_cursos.entity.Curso;


public interface CursoService {
    
    List<Curso> getAll();
    Curso save(Curso curso);
    Curso update (String id, Curso curso);
    Curso delete (String id);

}