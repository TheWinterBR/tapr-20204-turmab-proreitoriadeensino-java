package br.univille.microservproreitoriadeensino.criacao_cursos.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.univille.microservproreitoriadeensino.criacao_cursos.entity.Curso;


@Repository
public interface CursoRepository 
    extends CrudRepository<Curso,String>{
    
}